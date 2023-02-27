package com.example.dartjonny.repository

import com.example.dartjonny.model.Player
import com.example.dartjonny.model.PlayerUpdate
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getPlayers(): Flow<List<Player>>

    suspend fun getPlayerById(id: Int): Player?

    suspend fun  insertPlayer(player: Player)

    suspend fun deletePlayer(player: Player)

    suspend fun updateScore(player: PlayerUpdate)
}