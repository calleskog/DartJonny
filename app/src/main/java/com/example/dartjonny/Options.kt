package com.example.dartjonny

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Options(navController: NavController) {
    Text(text = "Options")
    Button(
        onClick = {
            navController.navigate(Screen.MainScreen.route)
        }
    ) {
        Text(text = "Tillbaka")
    }
}