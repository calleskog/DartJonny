package com.example.dartjonny

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                navController.navigate(Screen.NewGameScreen.route)
            }
        ) {
            Text(text = "Nytt spel")
        }

        Button(
            onClick = {
                navController.navigate(Screen.OptionsScreen.route)
            }
        ) {
            Text(text = "Spel inställning")
        }

        Button(
            modifier = Modifier.padding(20.dp),
            onClick = {
                navController.navigate(Screen.EndOfGameScreen.route)
            }
        ) {
            Text(text = "Leaderboard")
        }
    }
}
