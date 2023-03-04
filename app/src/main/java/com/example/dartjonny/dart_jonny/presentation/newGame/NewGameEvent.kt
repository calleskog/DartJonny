package com.example.dartjonny.dart_jonny.presentation.newGame

import com.example.dartjonny.dart_jonny.model.Player

sealed class NewGameEvent {
    data class DeletePlayer(val player: Player): NewGameEvent()

    object ResetScore: NewGameEvent()
}
