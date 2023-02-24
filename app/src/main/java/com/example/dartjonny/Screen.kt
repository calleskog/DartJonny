package com.example.dartjonny

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object NewGame : Screen("new_game")
    object Options : Screen("options")
}
