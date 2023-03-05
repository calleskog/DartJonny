package com.example.dartjonny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dartjonny.dart_jonny.presentation.addPlayer.AddPlayerScreen
import com.example.dartjonny.dart_jonny.presentation.completedGame.EndOfGameScreen
import com.example.dartjonny.dart_jonny.presentation.newGame.NewGameScreen
import com.example.dartjonny.dart_jonny.presentation.options.OptionsScreen
import com.example.dartjonny.dart_jonny.presentation.playGame.PlayGameScreen
import com.example.dartjonny.ui.theme.DartJonnyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DartJonnyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.MainScreen.route
                ) {
                    composable(route = Screen.MainScreen.route) {
                        MainScreen(navController = navController)
                    }
                    composable(route = Screen.NewGameScreen.route) {
                        NewGameScreen(navController = navController)
                    }
                    composable(route = Screen.AddPlayerScreen.route) {
                        AddPlayerScreen(navController = navController)
                    }
                    composable(route = Screen.OptionsScreen.route) {
                        OptionsScreen(navController = navController)
                    }
                    composable(route = Screen.PlayGameScreen.route) {
                        PlayGameScreen(navController = navController)
                    }
                    composable(route = Screen.EndOfGameScreen.route) {
                        EndOfGameScreen(navController = navController)
                    }
                }
            }
        }
    }
}