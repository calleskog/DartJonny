package com.example.dartjonny.dart_jonny.presentation.playGame

sealed class PlayGameEvent {
    data class Hits(val number: Int): PlayGameEvent()
    object ClearScore: PlayGameEvent()
    object NextPlayer: PlayGameEvent()
}
