package com.example.dartjonny.dart_jonny.presentation.newGame

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dartjonny.dart_jonny.useCases.newGame.NewGameUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewGameViewModel @Inject constructor(
    private val newGameUseCases: NewGameUseCases
): ViewModel() {
    private val _players = mutableStateOf(NewGameState())
    val players: State<NewGameState> = _players

    private var getPlayersJob: Job? = null

    init {
        getPlayers()
    }

    fun onEvent(event: NewGameEvent) {
        when(event) {
            is NewGameEvent.DeletePlayer -> {
                viewModelScope.launch {
                    newGameUseCases.deletePlayer(event.player)
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
            }
            .launchIn(viewModelScope)
    }
}