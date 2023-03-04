package com.example.dartjonny.dart_jonny.useCases.newGame

import com.example.dartjonny.dart_jonny.data.repository.PlayerRepository
import com.example.dartjonny.dart_jonny.model.Player

class UpdatePlayerScore(
    private val repository: PlayerRepository
) {
    suspend operator fun invoke(playerName: String, score: Int) {
        repository.update(playerName, score)
    }
}