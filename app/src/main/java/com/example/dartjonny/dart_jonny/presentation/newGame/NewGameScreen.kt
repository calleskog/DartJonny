package com.example.dartjonny.dart_jonny.presentation.newGame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.DartViewModel
import com.example.dartjonny.Screen
import com.example.dartjonny.dart_jonny.presentation.addPlayer.components.PlayerItem


@Composable
fun NewGameScreen(
    navController: NavController,
    viewModel: DartViewModel = hiltViewModel()
) {
    val state = viewModel.players.value
    val scaffoldState = rememberScaffoldState()
    Column() {
        Scaffold(
            modifier = Modifier.weight(9F).fillMaxSize(),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigate(Screen.AddPlayerScreen.route) },

                ) {
                    Text(text = "Lägg till spelare")
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            scaffoldState = scaffoldState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            navController.navigate(Screen.MainScreen.route)
                        }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                        Text(text = "Tillbaka")
                    }

                    Text(
                        text = "Spelare",
                        style = MaterialTheme.typography.h4,
                        modifier = Modifier.padding(end = 35.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.players) { player ->
                        PlayerItem(
                            player = player,
                            onDeleteClick = {
                                viewModel.onNewGameEvent(NewGameEvent.DeletePlayer(player))
                            }
                        )
                    }
                }
            }
        }
        Button(
            modifier = Modifier.weight(1F).fillMaxSize().background(Color.DarkGray),
            onClick = {
                viewModel.onNewGameEvent(NewGameEvent.ResetScore)
                navController.navigate(Screen.PlayGameScreen.route)
            }
        ) {
            Text(text = "STARTA SPEL")
        }
    }
}

