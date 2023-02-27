package com.example.dartjonny.useCases

import com.example.dartjonny.model.Player
import com.example.dartjonny.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPlayers(
    private val repository: PlayerRepository
) {
    operator fun invoke(): Flow<List<Player>> {
        return repository.getPlayers().map { players ->
            players.shuffled()
        }
    }
}