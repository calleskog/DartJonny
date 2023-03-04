package com.example.dartjonny.dart_jonny.presentation.playGame

import com.example.dartjonny.dart_jonny.model.Player

sealed class PlayGameEvent {
    data class Hits(val number: Int): PlayGameEvent()
    object ClearScore: PlayGameEvent()
    data class UpdatePlayerScore(val player: Player): PlayGameEvent()
}
