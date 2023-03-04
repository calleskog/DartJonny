package com.example.dartjonny.dart_jonny.data.repository

import com.example.dartjonny.dart_jonny.model.Player
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getPlayers(): Flow<List<Player>>

    suspend fun insertPlayer(player: Player)

    suspend fun deletePlayer(player: Player)

    suspend fun update(playerName: String, score: Int)

    suspend fun resetScore(score: Int = 0)
}