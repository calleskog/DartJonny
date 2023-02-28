package com.example.dartjonny.dart_jonny.presentation.newGame

import com.example.dartjonny.dart_jonny.model.Player

sealed class NewGameEvent {
    object addPlayerButton: NewGameEvent()
    data class DeletePlayer(val player: Player): NewGameEvent()
    object startNewGameButton: NewGameEvent()
    object goBackButton: NewGameEvent()
}
