package com.example.dartjonny.dart_jonny.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Update

@Entity
data class Player(
    val playerName: String,
    val points: Double,
    @PrimaryKey val id: Int? = null
)

@Entity
data class PlayerUpdate (
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "points")
    val points: Double
)

class InvalidPlayerException(message: String): Exception(message)