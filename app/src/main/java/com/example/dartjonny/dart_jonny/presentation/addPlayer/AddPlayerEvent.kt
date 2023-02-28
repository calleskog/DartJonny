package com.example.dartjonny.dart_jonny.presentation.addPlayer

sealed class AddPlayerEvent{
    data class EnteredPlayerName(val value: String): AddPlayerEvent()
    object SavePlayer: AddPlayerEvent()
}
