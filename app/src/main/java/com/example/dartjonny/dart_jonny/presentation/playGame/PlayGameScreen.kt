package com.example.dartjonny.dart_jonny.presentation.playGame

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController


@Composable
fun PlayGameScreen(
    navController: NavController,
    viewModel: PlayGameViewModel = hiltViewModel()
) {
    val scoreState = viewModel.score.value

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

            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {

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
                        .weight(1f).padding(end = 3.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                        onClick = {}
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }

                    Text(
                        text = scoreState.score,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(3f).background(Color.White),
                        fontSize = 30.sp,
                        maxLines = 1
                    )

                    Button(modifier = Modifier
                        .weight(1f).padding(start = 3.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                        onClick = {}
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
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(1)) }
                        )
                        ScoreButton(
                            number = "2",
                            modifier = Modifier
                                .background(Color.DarkGray)
                                .weight(1f),
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(2)) }
                        )
                        ScoreButton(
                            number = "3",
                            modifier = Modifier
                                .background(Color.DarkGray)
                                .weight(1f),
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(3)) }
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
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(4)) }
                        )
                        ScoreButton(
                            number = "5",
                            modifier = Modifier
                                .background(Color.DarkGray)
                                .weight(1f),
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(5)) }
                        )
                        ScoreButton(
                            number = "6",
                            modifier = Modifier
                                .background(Color.DarkGray)
                                .weight(1f),
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(6)) }
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
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(7)) }
                        )
                        ScoreButton(
                            number = "8",
                            modifier = Modifier
                                .background(Color.DarkGray)
                                .weight(1f),
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(8)) }
                        )
                        ScoreButton(
                            number = "9",
                            modifier = Modifier
                                .background(Color.DarkGray)
                                .weight(1f),
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(9)) }
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
                            onClick = { viewModel.onEvent(PlayGameEvent.Hits(0)) }
                        )
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .background(Color.Gray)
                                .weight(1f)
                                .clickable { viewModel.onEvent(PlayGameEvent.ClearScore) }
                        ) {
                            Icon(imageVector = Icons.Default.KeyboardBackspace,
                                contentDescription = "Delete",
                                modifier = Modifier.size(45.dp)
                            )
                        }
                    }
                }
            }

        }
    }
}

