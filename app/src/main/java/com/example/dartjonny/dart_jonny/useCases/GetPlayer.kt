package com.example.dartjonny.dart_jonny.useCases

import com.example.dartjonny.dart_jonny.model.Player
import com.example.dartjonny.dart_jonny.data.repository.PlayerRepository

class GetPlayer(
    private val repository: PlayerRepository
) {

    suspend operator fun invoke(id: Int): Player? {
        return repository.getPlayerById(id)
    }
}