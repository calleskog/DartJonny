package com.example.dartjonny.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dartjonny.model.Player

@Database(
    entities = [Player::class],
    version = 1
)
abstract class PlayerDatabase: RoomDatabase() {
    abstract val playerDao: PlayerDao

    companion object {
        const val DATABASE_NAME = "players_db"
    }
}