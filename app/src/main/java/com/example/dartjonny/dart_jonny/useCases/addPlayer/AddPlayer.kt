package com.example.dartjonny.dart_jonny.useCases.addPlayer

import com.example.dartjonny.dart_jonny.model.InvalidPlayerException
import com.example.dartjonny.dart_jonny.model.Player
import com.example.dartjonny.dart_jonny.data.repository.PlayerRepository

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