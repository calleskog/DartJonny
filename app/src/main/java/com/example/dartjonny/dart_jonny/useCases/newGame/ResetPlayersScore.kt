package com.example.dartjonny.dart_jonny.useCases.newGame

import com.example.dartjonny.dart_jonny.data.repository.PlayerRepository
import com.example.dartjonny.dart_jonny.model.Player

class ResetPlayersScore(
    private val repository: PlayerRepository
) {
    suspend operator fun invoke(score: Int = 0) {
        repository.resetScore(score)
    }
}