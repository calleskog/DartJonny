package com.example.dartjonny.dart_jonny.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    val playerName: String,
    val points: Int = 0,
    val color: Int,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)

class InvalidPlayerException(message: String): Exception(message)