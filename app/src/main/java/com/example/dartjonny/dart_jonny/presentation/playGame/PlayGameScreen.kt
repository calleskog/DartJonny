package com.example.dartjonny.dart_jonny.presentation.playGame

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardBackspace
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.DartViewModel
import com.example.dartjonny.Screen
import com.example.dartjonny.dart_jonny.presentation.playGame.components.Leaderboard


@Composable
fun PlayGameScreen(
    navController: NavController,
    viewModel: DartViewModel = hiltViewModel()
) {
    val playGameState = viewModel.playGameState.value
    val playersState = viewModel.players.value

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .weight(4f)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.DarkGray)
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(playersState.players) { player ->
                        Leaderboard(
                            player = player,
                            currentPlayer = player == playersState.players[playGameState.currentPlayerIndex]
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = playGameState.currentTarget,
                    fontSize = 50.sp
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxSize()
        ) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.Black)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(modifier = Modifier
                        .weight(1f)
                        .padding(end = 3.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                        onClick = {}
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }

                    Text(
                        text = "Antal träffar",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(3f)
                            .background(Color.White),
                        fontSize = 30.sp,
                        maxLines = 1
                    )

                    Button(modifier = Modifier
                        .weight(1f)
                        .padding(start = 3.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                        enabled = playGameState.nextPlayerButton,
                        onClick = {
                            if (playGameState.currentTargetIndex == viewModel.targets.size-1 && playGameState.currentPlayerIndex == playersState.players.size-1) {
                                viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerWins)
                                navController.navigate(Screen.EndOfGameScreen.route)
                            }
                            viewModel.onPlayGameEvent(PlayGameEvent.NextPlayer)
                        }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Next player")
                    }
                }
            }

            Box(modifier = Modifier
                .weight(4f)
                .fillMaxSize()
                .background(Color.Gray)
                .padding(top = 5.dp)
            ) {
                when (playGameState.currentTarget) {
                    in listOf("D", "T") -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                ScoreButton(
                                    number = "1",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(1))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.doubleTripleButton
                                )
                                ScoreButton(
                                    number = "2",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(2))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.doubleTripleButton
                                )
                                ScoreButton(
                                    number = "3",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(3))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.doubleTripleButton
                                )
                            }

                            TextField(
                                value = playGameState.doubleTripleNumber,
                                onValueChange = {viewModel.onPlayGameEvent(PlayGameEvent.EnteredDoubleTriple(it))},
                                textStyle = TextStyle.Default.copy(fontSize = 28.sp),
                                modifier = Modifier
                                    .size(width = 70.dp, height = 70.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .border(width = 1.dp, color = Color.Black)
                            )
                        }
                    }
                    "41" -> {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Fick du 41 poäng på tre pilar?")
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                ScoreButton(
                                    number = "JAPP",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(1))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    }
                                )
                                ScoreButton(
                                    number = "NOPE",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(0))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    }
                                )
                            }
                        }
                    }
                    else -> {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(1.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                ScoreButton(
                                    number = "1",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(1))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                                ScoreButton(
                                    number = "2",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(2))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                                ScoreButton(
                                    number = "3",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(3))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                ScoreButton(
                                    number = "4",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(4))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                                ScoreButton(
                                    number = "5",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(5))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                                ScoreButton(
                                    number = "6",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(6))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                ScoreButton(
                                    number = "7",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(7))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                                ScoreButton(
                                    number = "8",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(8))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                                ScoreButton(
                                    number = "9",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(9))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(Color.Gray)
                                        .weight(1f)
                                )
                                ScoreButton(
                                    number = "0",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(0))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .background(Color.Gray)
                                        .weight(1f)
                                        .clickable { viewModel.onPlayGameEvent(PlayGameEvent.ClearScore) }
                                ) {
                                    Icon(imageVector = Icons.Default.KeyboardBackspace,
                                        contentDescription = "Delete",
                                        modifier = Modifier.height(45.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

