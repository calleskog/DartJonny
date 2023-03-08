package com.example.dartjonny.dart_jonny.presentation.newGame

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.DartViewModel
import com.example.dartjonny.Screen
import com.example.dartjonny.dart_jonny.presentation.newGame.compontents.DragDropColumn


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewGameScreen(
    navController: NavController,
    viewModel: DartViewModel = hiltViewModel()
) {
    val playersState = viewModel.players.value
    val scaffoldState = rememberScaffoldState()

    Column {
        Scaffold(
            modifier = Modifier
                .weight(9F)
                .fillMaxSize(),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { navController.navigate(Screen.AddPlayerScreen.route) },
                    backgroundColor = Color(255, 85, 0),
                    modifier = Modifier.clip(CircleShape).border(1.dp, Color.Black, shape = CircleShape)
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add player")
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
                        },
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }

                    Text(
                        text = "Spelare",
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 85.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                DragDropColumn(
                    items = playersState.players,
                    onSwap = viewModel::swapSections
                ) { player ->
                    Card {
                        Row(
                            modifier = Modifier.fillMaxWidth().background(Color.Gray),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = player.playerName.uppercase(),
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier
                                    .padding(16.dp),
                            )
                            IconButton(
                                onClick = { viewModel.onNewGameEvent(NewGameEvent.DeletePlayer(player)) },
                            ) {
                                Icon(imageVector = Icons.Filled.PersonRemove, contentDescription = "Delete", tint = Color.Black)
                            }
                        }
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .fillMaxSize()
                .background(Color(40,40,40))
                .clickable(
                    onClick = {
                        viewModel.onNewGameEvent(NewGameEvent.ResetScore)
                        playersState.players.mapIndexed { index, player -> viewModel.onNewGameEvent(NewGameEvent.UpdatePlayerOrder(player.playerName, index)) }
                        navController.navigate(Screen.PlayGameScreen.route)
                    }),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "STARTA SPELET", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
        }
    }
}

