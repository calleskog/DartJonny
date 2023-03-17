package com.example.dartjonny

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object NewGameScreen : Screen("new_game_screen")
    object AddPlayerScreen: Screen("add_player_screen")
    object PlayGameScreen: Screen("play_game_screen")
    object EndOfGameScreen: Screen("end_of_game_screen")
    object LeaderboardScreen: Screen("leaderboard_screen")
}
