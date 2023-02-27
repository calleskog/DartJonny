package com.example.dartjonny.presentation.newGame

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dartjonny.useCases.PlayerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewGameViewModel @Inject constructor(
    private val playerUseCases: PlayerUseCases
): ViewModel() {
    private val _state = mutableStateOf(PlayersState())
    val state: State<PlayersState> = _state

    private var getPlayersJob: Job? = null

    init {
        getPlayers()
    }

    fun onEvent(event: NewGameEvent) {
        when(event) {
            is NewGameEvent.DeletePlayer -> {
                viewModelScope.launch {
                    playerUseCases.deletePlayer(event.player)
                }
            }
        }
    }

    private fun getPlayers() {
        getPlayersJob?.cancel()
        getPlayersJob = playerUseCases.getPlayers()
            .launchIn(viewModelScope)
    }
}