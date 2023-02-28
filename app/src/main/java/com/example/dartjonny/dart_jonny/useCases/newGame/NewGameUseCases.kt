package com.example.dartjonny.dart_jonny.useCases.newGame

import com.example.dartjonny.dart_jonny.useCases.GetPlayers

data class NewGameUseCases(
    val getPlayers: GetPlayers,
    val deletePlayer: DeletePlayer
)
