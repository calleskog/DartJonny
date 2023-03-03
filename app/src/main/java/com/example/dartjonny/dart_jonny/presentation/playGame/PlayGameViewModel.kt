package com.example.dartjonny.dart_jonny.presentation.playGame

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dartjonny.dart_jonny.useCases.newGame.NewGameUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PlayGameViewModel @Inject constructor(
    private val newGameUseCases: NewGameUseCases
): ViewModel() {
    private val _score = mutableStateOf(PlayGameState())
    val score: State<PlayGameState> = _score

    fun onEvent(event: PlayGameEvent) {
        when(event) {
            is PlayGameEvent.Hits -> calculateScore(event.number)
            is PlayGameEvent.ClearScore -> _score.value = PlayGameState()
            is PlayGameEvent.NextPlayer -> updateScoreAndNextPlayer()
        }
    }

    private fun updateScoreAndNextPlayer() {

    }

    private fun calculateScore(number: Int) {
        _score.value = score.value.copy(
            score = number.toString()
        )
    }
}