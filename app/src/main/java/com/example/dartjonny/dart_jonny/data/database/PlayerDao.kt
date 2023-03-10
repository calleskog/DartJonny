package com.example.dartjonny.dart_jonny.data.database

import androidx.room.*
import com.example.dartjonny.dart_jonny.model.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {

    @Query("SELECT * FROM players_db")
    fun getPlayers(): Flow<List<Player>>

    @Insert(onConflict = OnConflictStrategy.ABORT )
    suspend fun insertPlayer(player: Player)

    @Delete
    suspend fun deletePlayer(player: Player)

    @Query("UPDATE players_db SET player_score=:score WHERE player_name=:playerName")
    suspend fun update(playerName: String, score: Int)

    @Query("UPDATE players_db SET player_score=:score")
    suspend fun resetScore(score: Int = 0)

    @Query("UPDATE players_db SET player_wins=:wins WHERE player_name=:playerName")
    suspend fun updateWins(playerName: String, wins: Int = 0)
}