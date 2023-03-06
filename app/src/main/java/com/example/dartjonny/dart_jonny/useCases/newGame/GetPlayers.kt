package com.example.dartjonny.dart_jonny.useCases.newGame

import com.example.dartjonny.dart_jonny.model.Player
import com.example.dartjonny.dart_jonny.data.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPlayers(
    private val repository: PlayerRepository
) {
    operator fun invoke(): Flow<List<Player>> {
        return repository.getPlayers().map { players ->
            players.sortedBy { it.orderId }
        }
    }
}