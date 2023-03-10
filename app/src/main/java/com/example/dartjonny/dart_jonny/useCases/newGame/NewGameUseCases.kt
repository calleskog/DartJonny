package com.example.dartjonny.dart_jonny.useCases.newGame

data class NewGameUseCases(
    val getPlayers: GetPlayers,
    val deletePlayer: DeletePlayer,
    val addPlayer: AddPlayer,
    val updatePlayerScore: UpdatePlayerScore,
    val resetPlayersScore: ResetPlayersScore,
    val updatePlayerWins: UpdatePlayerWins
)
