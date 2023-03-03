package com.example.dartjonny.dart_jonny.presentation.playGame

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dartjonny.dart_jonny.presentation.addPlayer.PlayerNameFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PlayGameViewModel @Inject constructor(
): ViewModel() {
    private val _score = mutableStateOf(PlayGameState(score = "Poäng"))
    val score: State<PlayGameState> = _score

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
            is PlayGameEvent.NextPlayer -> {
                TODO()
            }
        }
    }

}