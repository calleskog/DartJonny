package com.example.dartjonny.dart_jonny.presentation.player

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dartjonny.dart_jonny.useCases.addPlayer.AddPlayerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class AddNewPlayerModel @Inject constructor(
    private val addPlayerUseCases: AddPlayerUseCases
): ViewModel() {
    var isDialogShown by mutableStateOf(false)

    private val _playerName = mutableStateOf("")
    val playerName: State<String> = _playerName

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: AddPlayerEvent) {
        when(event) {
            is AddPlayerEvent.EnteredPlayerName -> {
                _playerName.value = playerName.value
            },
            is AddPlayerEvent.SavePlayer -> {
                print("ok")
            }
        }
    }

    sealed class UiEvent {
        object SavePlayer: UiEvent()
    }

    fun onAddPlayerClick() {
        isDialogShown = true
    }

    fun onDissmissDialog() {
        isDialogShown = false
    }
}