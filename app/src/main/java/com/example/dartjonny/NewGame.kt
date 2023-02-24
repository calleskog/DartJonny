package com.example.dartjonny

import androidx.activity.ComponentActivity
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NewGame(navController: NavController) {
    Text(text = "Spelare")
    Button(
        onClick = {
            navController.navigate(Screen.MainScreen.route)
        }
    ) {
        Text(text = "Tillbaka")
    }
}