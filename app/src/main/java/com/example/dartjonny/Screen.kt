package com.example.dartjonny

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object NewGameScreen : Screen("new_game_screen")
    object AddPlayerScreen: Screen("add_player_screen")
    object OptionsScreen: Screen("option_screen")
    object PlayGameScreen: Screen("play_game_screen")
}
