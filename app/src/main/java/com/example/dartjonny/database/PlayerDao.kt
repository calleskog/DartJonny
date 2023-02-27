package com.example.dartjonny.database

import androidx.room.*
import com.example.dartjonny.model.Player
import com.example.dartjonny.model.PlayerUpdate
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player")
    fun getPlayers(): Flow<List<Player>>

    @Query("SELECT * FROM player WHERE id = :id")
    suspend fun getPlayerById(id: Int): Player?

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertPlayer(player: Player)

    @Delete
    suspend fun deletePlayer(player: Player)

    @Update(entity = Player::class)
    suspend fun updateScore(obj: PlayerUpdate)
}