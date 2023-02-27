package com.example.dartjonny.presentation.newGame

import com.example.dartjonny.model.Player

data class PlayersState(
    val players: List<Player> = emptyList()
)
