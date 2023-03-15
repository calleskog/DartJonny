package com.example.dartjonny.dart_jonny.presentation.playGame

sealed class PlayGameEvent {
    data class Hits(val hits: Int): PlayGameEvent()
    object UpdatePlayerScore: PlayGameEvent()
    object UpdatePlayerWins: PlayGameEvent()
    data class EnteredOneDoubleTriple(val value: String): PlayGameEvent()
    data class EnteredTwoDoubleTriple(val value: String): PlayGameEvent()
    data class EnteredThreeDoubleTriple(val value: String): PlayGameEvent()
    object NextPlayer: PlayGameEvent()
    object RestoreScore: PlayGameEvent()
}
