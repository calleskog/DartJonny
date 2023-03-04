package com.example.dartjonny.dart_jonny.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dartjonny.dart_jonny.data.database.PlayerDatabase

@Entity(tableName = PlayerDatabase.DATABASE_NAME)
data class Player(
    @ColumnInfo(name = "player_name")
    val playerName: String,

    @ColumnInfo(name = "player_score")
    val score: Int = 0,

    @ColumnInfo(name = "player_color")
    val color: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)

class InvalidPlayerException(message: String): Exception(message)