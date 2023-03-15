package com.example.dartjonny.dart_jonny.presentation.playGame

data class PlayGameState(
    val numberOfHits: String = "",
    val scoreButton: Boolean = true,

    val nextPlayerButton: Boolean = false,

    val doubleTripleOneHit: String = "",
    val doubleTripleTwoHit: String = "",
    val doubleTripleThreeHit: String = "",
    val doubleTripleHits: Boolean = false,

    val currentPlayerIndex: Int = 0,

    val currentTarget: String = "",
    val currentTargetIndex: Int = 0,

    val restoreScoreButton: Boolean = false
)