package com.example.dartjonny.dart_jonny.useCases.game

import com.example.dartjonny.dart_jonny.model.PlayerUpdate
import com.example.dartjonny.dart_jonny.data.repository.PlayerRepository

class UpdateScore(
    private val repository: PlayerRepository
) {

    suspend operator fun invoke(player: PlayerUpdate) {
        repository.updateScore(player)
    }
}