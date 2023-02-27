package com.example.dartjonny.useCases

import com.example.dartjonny.model.Player
import com.example.dartjonny.repository.PlayerRepository

class DeletePlayer(
    private val repository: PlayerRepository
) {

    suspend operator fun invoke(player: Player) {
        repository.deletePlayer(player)
    }
}