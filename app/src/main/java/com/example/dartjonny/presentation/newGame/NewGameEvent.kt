package com.example.dartjonny.presentation.newGame

import com.example.dartjonny.model.Player

sealed class NewGameEvent {
    data class DeletePlayer(val player: Player): NewGameEvent()
}
