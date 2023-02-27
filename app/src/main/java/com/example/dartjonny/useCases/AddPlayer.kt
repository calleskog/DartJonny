package com.example.dartjonny.useCases

import com.example.dartjonny.model.InvalidPlayerException
import com.example.dartjonny.model.Player
import com.example.dartjonny.repository.PlayerRepository

class AddPlayer(
    private val repository: PlayerRepository
) {
    @Throws(InvalidPlayerException::class)
    suspend operator fun invoke(player: Player) {
        if (player.playerName.isBlank()) {
            throw InvalidPlayerException("Namnet kan ej vara tomt!")
        }

        repository.insertPlayer(player)
    }
}