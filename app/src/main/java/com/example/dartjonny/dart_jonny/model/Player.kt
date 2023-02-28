package com.example.dartjonny.dart_jonny.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Player(
    val playerName: String,
    val points: Double = 0.0,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)

class InvalidPlayerException(message: String): Exception(message)