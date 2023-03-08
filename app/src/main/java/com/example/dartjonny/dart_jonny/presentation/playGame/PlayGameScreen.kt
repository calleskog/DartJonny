package com.example.dartjonny.dart_jonny.presentation.playGame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardBackspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.DartViewModel
import com.example.dartjonny.R
import com.example.dartjonny.Screen
import com.example.dartjonny.dart_jonny.presentation.playGame.components.Leaderboard
import com.example.dartjonny.dart_jonny.presentation.playGame.components.ScoreButton


@Composable
fun PlayGameScreen(
    navController: NavController,
    viewModel: DartViewModel = hiltViewModel()
) {
    val playGameState = viewModel.playGameState.value
    val playersState = viewModel.players.value

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(4f)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(5f)
                    .fillMaxSize()
                    .background(Color(60, 55, 55))
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
                    .weight(2f)
                    .fillMaxSize()
                    .background(Color(198, 198, 198)),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dart_board),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
                Text(
                    text = playGameState.currentTarget,
                    fontSize = 70.sp,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxSize()
                .background(Color(77,77,77))
        ) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxSize()
            ) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(20.dp)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ANTAL TRÄFFAR",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(3f)
                            .background(Color.White),
                        fontSize = 20.sp,
                        maxLines = 1
                    )

                    Button(modifier = Modifier
                        .weight(1f)
                        .padding(start = 3.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(255, 85, 0)),
                        enabled = playGameState.nextPlayerButton,
                        onClick = {
                            if (playGameState.currentTargetIndex == viewModel.targets.size-1 && playGameState.currentPlayerIndex == playersState.players.size-1) {
                                viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerWins)
                                navController.navigate(Screen.EndOfGameScreen.route)
                            } else viewModel.onPlayGameEvent(PlayGameEvent.NextPlayer)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Next player"
                        )
                    }
                }
            }

            Box(modifier = Modifier
                .weight(4f)
                .fillMaxSize()
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

                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .background(Color.Gray)
                                    .weight(1f)
                                    .clickable(onClick = {
                                        viewModel.onPlayGameEvent(
                                            PlayGameEvent.RestoreScore
                                        )
                                    }, enabled = playGameState.restoreScoreButton)
                            ) {
                                Icon(imageVector = Icons.Default.KeyboardBackspace,
                                    contentDescription = "Restore score",
                                    modifier = Modifier.size(50.dp),
                                )
                            }
                        }
                    }
                    "41" -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp),
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
                                    },
                                    enabled = playGameState.scoreButton
                                )
                                ScoreButton(
                                    number = "NOPE",
                                    modifier = Modifier
                                        .background(Color.DarkGray)
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(0))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                            }
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .background(Color.Gray)
                                    .weight(1f)
                                    .clickable(onClick = {
                                        viewModel.onPlayGameEvent(
                                            PlayGameEvent.RestoreScore
                                        )
                                    }, enabled = playGameState.restoreScoreButton)
                            ) {
                                Icon(imageVector = Icons.Default.KeyboardBackspace,
                                    contentDescription = "Restore score",
                                    modifier = Modifier.size(50.dp)
                                )
                            }
                        }
                    }
                    else -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(1.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize().weight(1f),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                ScoreButton(
                                    number = "1",
                                    modifier = Modifier
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
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(3))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxSize().weight(1f),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                ScoreButton(
                                    number = "4",
                                    modifier = Modifier
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
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(6))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxSize().weight(1f),
                                horizontalArrangement = Arrangement.spacedBy(1.dp)
                            ) {
                                ScoreButton(
                                    number = "7",
                                    modifier = Modifier
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
                                        .weight(1f),
                                    onClick = {
                                        viewModel.onPlayGameEvent(PlayGameEvent.Hits(9))
                                        viewModel.onPlayGameEvent(PlayGameEvent.UpdatePlayerScore)
                                    },
                                    enabled = playGameState.scoreButton
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxSize().weight(1f),
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
                                        .clickable(onClick = {
                                            viewModel.onPlayGameEvent(PlayGameEvent.RestoreScore)
                                        },
                                    enabled = playGameState.restoreScoreButton)
                                ) {
                                    Icon(imageVector = Icons.Default.KeyboardBackspace,
                                        contentDescription = "Restore score",
                                        modifier = Modifier.size(33.dp)
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

