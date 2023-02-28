package com.example.dartjonny.dart_jonny.presentation.newGame

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.Screen
import com.example.dartjonny.presentation.newGame.AddPlayerDialogScreen
import com.example.dartjonny.dart_jonny.presentation.player.AddNewPlayerModel

@Composable
fun NewGameScreen(
    navController: NavController,
    viewModel: NewGameViewModel = hiltViewModel()
) {
    Column() {
        Text(text = "Spelare")

        Button(
            onClick = {
                navController.navigate(Screen.MainScreen.route)
            }
        ) {
            Text(text = "Tillbaka")
        }

        Button(
            onClick = {
                viewModel.onAddPlayerClick()
            }
        ) {
            Text(text = "Lägg till spelare")
            Icon(Icons.Default.Add, contentDescription = null)
        }
    }
    if (viewModel.isDialogShown) {
        AddPlayerDialogScreen(
            onDismiss = {
                viewModel.onDissmissDialog()
            },
            onConfirm = {
                // TODO: Lägg till spelare (viewmodel.addPlayer)
            }
        )
    }
}

