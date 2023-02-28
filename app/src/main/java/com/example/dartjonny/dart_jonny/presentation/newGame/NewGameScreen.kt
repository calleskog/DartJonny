package com.example.dartjonny.dart_jonny.presentation.newGame

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.Screen
import com.example.dartjonny.dart_jonny.presentation.addPlayer.components.PlayerItem


@Composable
fun NewGameScreen(
    navController: NavController,
    viewModel: NewGameViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column() {
        Row() {
            Text(text = "Spelare")

            Button(
                onClick = {
                    navController.navigate(Screen.MainScreen.route)
                }
            ) {
                Text(text = "Tillbaka")
            }
        }

        Button(
            onClick = {
                navController.navigate(Screen.AddPlayerScreen.route)
            }
        ) {
            Text(text = "Lägg till spelare")
            Icon(Icons.Default.Add, contentDescription = null)
        }

        LazyColumn(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
            items(state.players) {player ->
                PlayerItem(
                    player = player,
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(
                                Screen.AddPlayerScreen.route
                            )
                        },
                    onDeleteClick = {
                        viewModel.onEvent(NewGameEvent.DeletePlayer(player))
                    }
                )
            }
        }
    }
}

