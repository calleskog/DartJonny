package com.example.dartjonny

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dartjonny.dart_jonny.model.InvalidPlayerException
import com.example.dartjonny.dart_jonny.model.Player
import com.example.dartjonny.dart_jonny.presentation.addPlayer.AddPlayerEvent
import com.example.dartjonny.dart_jonny.presentation.addPlayer.PlayerNameFieldState
import com.example.dartjonny.dart_jonny.presentation.newGame.NewGameEvent
import com.example.dartjonny.dart_jonny.presentation.newGame.NewGameState
import com.example.dartjonny.dart_jonny.presentation.playGame.PlayGameEvent
import com.example.dartjonny.dart_jonny.presentation.playGame.PlayGameState
import com.example.dartjonny.dart_jonny.useCases.newGame.NewGameUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class DartViewModel @Inject constructor(
    private val newGameUseCases: NewGameUseCases
): ViewModel() {
    private val _players = mutableStateOf(NewGameState())
    val players: State<NewGameState> = _players

    private val _playerName = mutableStateOf(PlayerNameFieldState(playerName = ""))
    val playerName: State<PlayerNameFieldState> = _playerName

    private val _playGameState = mutableStateOf(PlayGameState())
    val playGameState: State<PlayGameState> = _playGameState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var getPlayersJob: Job? = null

    private var lastScore: Int = 0

    val targets = listOf("19", "18", "D", "17", "41", "T", "20", "B")

    private val _uiState = MutableStateFlow<List<Section>>(listOf())
    val uiState = _uiState.asStateFlow()

    fun swapSections(from: Int, to: Int) {
        val fromItem = _uiState.value[from]
        val toItem = _uiState.value[to]
        val newList = _uiState.value.toMutableList()
        newList[from] = toItem
        newList[to] = fromItem

        _uiState.value = newList
    }

    fun sectionClicked(item: Section) {
        println("Clicked $item")
    }


    init {
        getPlayers()
        _playGameState.value = playGameState.value.copy(
            currentTarget = targets[playGameState.value.currentTargetIndex]
        )
    }

    fun onPlayGameEvent(event: PlayGameEvent) {
        when (event) {
            is PlayGameEvent.Hits -> {
                lastScore = players.value.players[playGameState.value.currentPlayerIndex].score
                _playGameState.value = playGameState.value.copy(
                    score = event.number.toString(),
                    scoreButton = false,
                    nextPlayerButton = true,
                    doubleTripleButton = false,
                    restoreScoreButton = true
                )
            }
            is PlayGameEvent.UpdatePlayerScore -> {
                viewModelScope.launch {
                    try {
                        newGameUseCases.updatePlayerScore(
                            playerName = players.value.players[playGameState.value.currentPlayerIndex].playerName,
                            score = resolveScore(
                                currentScore = players.value.players[playGameState.value.currentPlayerIndex].score,
                                numberOfHits = playGameState.value.score.toInt(),
                                target = playGameState.value.currentTarget
                            )
                        )
                    } catch (e: InvalidPlayerException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Försök igen"
                            )
                        )
                    }
                }
            }
            is PlayGameEvent.UpdatePlayerWins -> {
                val winningPlayer = players.value.players.maxByOrNull { it.score }!!
                viewModelScope.launch {
                    try {
                        newGameUseCases.updatePlayerWins(
                            playerName = winningPlayer.playerName,
                            wins = winningPlayer.wins + 1
                        )
                    } catch (e: InvalidPlayerException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Försök igen"
                            )
                        )
                    }
                }
            }
            is PlayGameEvent.EnteredDoubleTriple -> {
                _playGameState.value = playGameState.value.copy(
                    doubleTripleNumber = event.value,
                    doubleTripleButton = true
                )
            }
            is PlayGameEvent.NextPlayer -> {
                if (playGameState.value.currentPlayerIndex < players.value.players.size - 1) {
                    _playGameState.value = playGameState.value.copy(
                        currentPlayerIndex = playGameState.value.currentPlayerIndex + 1,
                        scoreButton = true,
                        nextPlayerButton = false,
                        doubleTripleButton = false,
                        doubleTripleNumber = "",
                        restoreScoreButton = false
                    )
                } else {
                    _playGameState.value = playGameState.value.copy(
                        currentPlayerIndex = 0,
                        currentTargetIndex = playGameState.value.currentTargetIndex + 1,
                        currentTarget = targets[playGameState.value.currentTargetIndex + 1],
                        scoreButton = true,
                        nextPlayerButton = false,
                        doubleTripleButton = false,
                        doubleTripleNumber = "",
                        restoreScoreButton = false
                    )
                }
            }
            is PlayGameEvent.RestoreScore -> {
                viewModelScope.launch {
                    newGameUseCases.updatePlayerScore(
                        playerName = players.value.players[playGameState.value.currentPlayerIndex].playerName,
                        score = lastScore
                    )
                    _playGameState.value = playGameState.value.copy(
                        restoreScoreButton = false,
                        scoreButton = true,
                        nextPlayerButton = false,
                        doubleTripleButton = true
                    )
                }
            }
        }
    }

    private fun resolveScore(currentScore: Int, numberOfHits: Int, target: String): Int {
        if (numberOfHits == 0) {
            return (currentScore+2-1)/2
        }

        if (target == "D") {
            return currentScore + (numberOfHits * playGameState.value.doubleTripleNumber.toInt() * 2)
        }

        if (target == "T") {
            return currentScore + (numberOfHits * playGameState.value.doubleTripleNumber.toInt() * 3)
        }

        if (target == "B") {
            return currentScore + numberOfHits * 25
        }

        if (target == "41") {
            return currentScore + 41
        }

        return currentScore + numberOfHits * target.toInt()
    }

    fun onNewGameEvent(event: NewGameEvent) {
        when(event) {
            is NewGameEvent.DeletePlayer -> {
                viewModelScope.launch {
                    newGameUseCases.deletePlayer(event.player)
                }
            }
            is NewGameEvent.ResetScore -> {
                viewModelScope.launch {
                    newGameUseCases.resetPlayersScore()
                }
            }
        }
    }

    fun onAddPlayerEvent(event: AddPlayerEvent) {
        when(event) {
            is AddPlayerEvent.EnteredPlayerName -> {
                _playerName.value = playerName.value.copy(
                    playerName = event.value
                )
            }
            is AddPlayerEvent.SavePlayer -> {
                viewModelScope.launch {
                    try {
                        newGameUseCases.addPlayer(
                            Player(
                                playerName = playerName.value.playerName
                            )
                        )
                        _eventFlow.emit(UiEvent.SavePlayer)
                    } catch(e: InvalidPlayerException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Kunde ej spara spelare"
                            )
                        )
                    }
                }
            }
        }
    }

    private fun getPlayers() {
        getPlayersJob?.cancel()
        getPlayersJob = newGameUseCases.getPlayers()
            .onEach { players ->
                _players.value = this.players.value.copy(
                    players = players
                )
                _uiState.value = this.players.value.players.map { Section(name = it.playerName) }
            }
            .launchIn(viewModelScope)
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SavePlayer: UiEvent()
    }
}

data class Section(
    val id: Int = internalId++,
    val name: String = "",
    val description: String = "",
    val color: Long = Random(id).nextLong()
) {
    companion object {
        private var internalId = 0
    }
}