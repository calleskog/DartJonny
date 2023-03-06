package com.example.dartjonny.dart_jonny.useCases.newGame

import com.example.dartjonny.dart_jonny.model.Player
import com.example.dartjonny.dart_jonny.data.repository.PlayerRepository

class UpdatePlayerOrder(
    private val repository: PlayerRepository
) {

    suspend operator fun invoke(playerName: String, orderId: Int) {
        repository.updatePlayerOrder(playerName, orderId)
    }
}