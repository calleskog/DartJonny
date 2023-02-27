package com.example.dartjonny.useCases

import com.example.dartjonny.model.Player
import com.example.dartjonny.model.PlayerUpdate
import com.example.dartjonny.repository.PlayerRepository

class UpdateScore(
    private val repository: PlayerRepository
) {

    suspend operator fun invoke(player: PlayerUpdate) {
        repository.updateScore(player)
    }
}