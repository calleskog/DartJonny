package com.example.dartjonny

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dartjonny.presentation.newGame.AddNewPlayerModel
import com.example.dartjonny.presentation.newGame.NewGameScreen

@Composable
fun Navigation(viewModel: AddNewPlayerModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =  Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.NewGame.route) {
            NewGameScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.Options.route) {
            Options(navController = navController)
        }
    }
}