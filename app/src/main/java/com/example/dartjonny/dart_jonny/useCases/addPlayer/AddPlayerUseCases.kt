package com.example.dartjonny.dart_jonny.useCases.addPlayer

import com.example.dartjonny.dart_jonny.useCases.GetPlayer
import com.example.dartjonny.dart_jonny.useCases.GetPlayers
import com.example.dartjonny.dart_jonny.useCases.game.UpdateScore
import com.example.dartjonny.dart_jonny.useCases.newGame.DeletePlayer

data class AddPlayerUseCases(
    val addPlayer: AddPlayer
)
