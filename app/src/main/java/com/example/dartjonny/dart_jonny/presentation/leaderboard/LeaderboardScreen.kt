package com.example.dartjonny.dart_jonny.presentation.leaderboard

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.DartViewModel
import com.example.dartjonny.Screen

@Composable
fun LeaderboardScreen(
    navController: NavController,
    viewModel: DartViewModel = hiltViewModel()
) {
    val playersState = viewModel.players.value

    val column1Weight = 1f
    val column2Weight = 5f
    val column3Weight = 5f

    Column(
        modifier = Modifier.background(Color(218, 196, 189, 255))
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
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
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Text(
                modifier = Modifier.padding(end = 30.dp),
                color = Color.White,
                text = "Leaderboard",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
        }

        Box(modifier = Modifier
            .weight(9F)
            .fillMaxSize()
        ) {


            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)) {
                // header
                item {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TableCell(text = "", weight = column1Weight)
                        TableCell(text = "Spelare", weight = column2Weight, 700)
                        TableCell(text = "Antal vinster", weight = column3Weight, 700)
                    }
                    Divider(color = Color.Black, thickness = 1.dp)
                }

                val sortedPlayers = playersState.players.sortedByDescending { it.wins }
                // rows
                itemsIndexed(sortedPlayers) { index, player ->
                    Row(Modifier.fillMaxWidth()) {
                        TableCell(text = (index+1).toString(), weight = column1Weight, 700)
                        TableCell(text = player.playerName.uppercase(), weight = column2Weight)
                        TableCell(text = player.wins.toString(), weight = column3Weight)
                    }
                }
            }


            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Color(255, 85, 0))
                    .height(60.dp)
                    .clickable(onClick = { navController.navigate(Screen.NewGameScreen.route) }),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "NYTT SPEL", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float,
    fontweight: Int = 380
) {
    Text(
        text = text,
        Modifier
            .weight(weight)
            .padding(8.dp),
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        color = Color.Black,
        fontWeight = FontWeight(fontweight)
    )
}