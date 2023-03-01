package com.example.dartjonny.dart_jonny.presentation.addPlayer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dartjonny.dart_jonny.model.InvalidPlayerException
import com.example.dartjonny.dart_jonny.model.Player
import com.example.dartjonny.dart_jonny.useCases.newGame.NewGameUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNewPlayerModel @Inject constructor(
    private val newGameUseCases: NewGameUseCases
): ViewModel() {
    private val _playerName = mutableStateOf(PlayerNameFieldState(playerName = ""))
    val playerName: State<PlayerNameFieldState> = _playerName

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: AddPlayerEvent) {
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

    sealed class UiEvent {
        data class ShowSnackbar(val message: String): UiEvent()
        object SavePlayer: UiEvent()
    }
}