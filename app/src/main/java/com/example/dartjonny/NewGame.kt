package com.example.dartjonny

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NewGame(navController: NavController, viewModel: AddNewPlayerModel) {
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
        AddPlayerDialog(
            onDismiss = {
                viewModel.onDissmissDialog()
            },
            onConfirm = {
                // TODO: Lägg till spelare (viewmodel.addPlayer)
            }
        )
    }
}

