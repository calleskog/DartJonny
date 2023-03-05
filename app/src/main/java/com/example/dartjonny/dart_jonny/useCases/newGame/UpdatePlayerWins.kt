package com.example.dartjonny.dart_jonny.useCases.newGame

import com.example.dartjonny.dart_jonny.data.repository.PlayerRepository

class UpdatePlayerWins(
    private val repository: PlayerRepository
) {
    suspend operator fun invoke(playerName: String, wins: Int) {
        repository.updateWins(playerName, wins)
    }
}