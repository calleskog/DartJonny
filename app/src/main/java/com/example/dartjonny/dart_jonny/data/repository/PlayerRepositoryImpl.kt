package com.example.dartjonny.dart_jonny.data.repository

import com.example.dartjonny.dart_jonny.data.database.PlayerDao
import com.example.dartjonny.dart_jonny.model.Player
import kotlinx.coroutines.flow.Flow

class PlayerRepositoryImpl(
    private val dao: PlayerDao
) : PlayerRepository {
    override fun getPlayers(): Flow<List<Player>> {
        return dao.getPlayers()
    }

    override suspend fun insertPlayer(player: Player) {
        return dao.insertPlayer(player)
    }

    override suspend fun deletePlayer(player: Player) {
        return dao.deletePlayer(player)
    }

    override suspend fun update(playerName: String, score: Int) {
        return dao.update(playerName, score)
    }

}