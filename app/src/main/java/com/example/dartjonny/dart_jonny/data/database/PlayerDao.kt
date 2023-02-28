package com.example.dartjonny.dart_jonny.data.database

import androidx.room.*
import com.example.dartjonny.dart_jonny.model.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player")
    fun getPlayers(): Flow<List<Player>>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertPlayer(player: Player)

    @Delete
    suspend fun deletePlayer(player: Player)
}