package com.example.dartjonny.dart_jonny.presentation.playGame

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dartjonny.dart_jonny.model.InvalidPlayerException
import com.example.dartjonny.dart_jonny.useCases.newGame.NewGameUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PlayGameViewModel @Inject constructor(
    private val newGameUseCases: NewGameUseCases
): ViewModel() {
    private val _score = mutableStateOf(PlayGameState(score = "Poäng"))
    val score: State<PlayGameState> = _score

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: PlayGameEvent) {
        when(event) {
            is PlayGameEvent.Hits -> {
                _score.value = score.value.copy(
                    score = event.number.toString()
                )
            }
            is PlayGameEvent.ClearScore -> {
                _score.value = score.value.copy(
                    score = "Poäng"
                )
            }
            is PlayGameEvent.UpdatePlayerScore -> {
                viewModelScope.launch {
                    try {
                        newGameUseCases.updatePlayerScore(
                            playerName = event.player.playerName,
                            score = event.player.score + score.value.score.toInt()
                        )
                    } catch(e: InvalidPlayerException){
                        _eventFlow.emit(
                            UiEvent.ShowSnackbar(
                                message = e.message ?: "Försök igen"
                            )
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
    }
}