package com.example.dartjonny.dart_jonny.presentation.playGame

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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


@SuppressLint("UnrememberedMutableState")
@Composable
fun PlayGameScreen(
    navController: NavController,
    viewModel: DartViewModel = hiltViewModel()
) {
    val scoreState = viewModel.score.value
    val playersState = viewModel.players.value
    val doubleTripleScoreState = viewModel.doubleTriple.value

    var currentPlayerIndex by remember { mutableStateOf(0) }
    var targetIndex by remember { mutableStateOf(0) }
    val targets = listOf("19", "18", "D", "17", "41", "T", "20", "B")

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
                            currentPlayer = player == playersState.players[currentPlayerIndex]
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
                    text = targets[targetIndex],
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
                        text = scoreState.score,
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
                        onClick = {
                            if (scoreState.score != "Poäng") {
                                viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore(playersState.players[currentPlayerIndex], targets[targetIndex]))
                                if (currentPlayerIndex < playersState.players.size-1) {
                                    currentPlayerIndex += 1
                                } else {
                                    currentPlayerIndex = 0
                                    targetIndex += 1
                                }
                            }
                            if (targetIndex >= targets.size-1) {
                                navController.navigate(Screen.NewGameScreen.route)
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Next")
                    }
                }
            }

            Box(modifier = Modifier
                .weight(4f)
                .fillMaxSize()
                .background(Color.Gray)
                .padding(top = 5.dp)
            ) {
                if (targets[targetIndex] !in listOf("D", "T")){
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
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(1)) }
                            )
                            ScoreButton(
                                number = "2",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .weight(1f),
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(2)) }
                            )
                            ScoreButton(
                                number = "3",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .weight(1f),
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(3)) }
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
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(4)) }
                            )
                            ScoreButton(
                                number = "5",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .weight(1f),
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(5)) }
                            )
                            ScoreButton(
                                number = "6",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .weight(1f),
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(6)) }
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
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(7)) }
                            )
                            ScoreButton(
                                number = "8",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .weight(1f),
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(8)) }
                            )
                            ScoreButton(
                                number = "9",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .weight(1f),
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(9)) }
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
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(0)) }
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
                else {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth().padding(10.dp),
                            horizontalArrangement = Arrangement.spacedBy(1.dp)
                        ) {
                            ScoreButton(
                                number = "1",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .weight(1f),
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(1)) }
                            )
                            ScoreButton(
                                number = "2",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .weight(1f),
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(2)) }
                            )
                            ScoreButton(
                                number = "3",
                                modifier = Modifier
                                    .background(Color.DarkGray)
                                    .weight(1f),
                                onClick = { viewModel.onPlayGameEvent(PlayGameEvent.Hits(3)) }
                            )
                        }

                        TextField(
                            value = doubleTripleScoreState.hits,
                            onValueChange = {viewModel.onPlayGameEvent(PlayGameEvent.EnteredDoubleTriple(it))},
                            textStyle = TextStyle.Default.copy(fontSize = 28.sp),
                            modifier = Modifier
                                .size(width = 70.dp, height = 70.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .border(width = 1.dp, color = Color.Black)
                        )

                    }
                }
            }
        }
    }
}

