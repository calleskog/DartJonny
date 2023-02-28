package com.example.dartjonny.dart_jonny.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dartjonny.dart_jonny.model.Player

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