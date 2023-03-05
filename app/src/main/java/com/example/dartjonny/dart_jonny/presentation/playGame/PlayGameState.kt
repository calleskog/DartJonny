package com.example.dartjonny.dart_jonny.presentation.playGame

data class PlayGameState(
    val score: String = "",
    val scoreButton: Boolean = true,

    val nextPlayerButton: Boolean = false,

    val doubleTripleNumber: String = "",
    val doubleTripleButton: Boolean = false,

    val currentPlayerIndex: Int = 0,

    val currentTarget: String = "",
    val currentTargetIndex: Int = 0
)