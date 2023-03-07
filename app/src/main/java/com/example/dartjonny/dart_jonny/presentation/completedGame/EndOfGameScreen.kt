package com.example.dartjonny.dart_jonny.presentation.completedGame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.DartViewModel
import com.example.dartjonny.Screen

@Composable
fun EndOfGameScreen(
    navController: NavController,
    viewModel: DartViewModel = hiltViewModel()
) {
    val playersState = viewModel.players.value

    val column1Weight = .2f
    val column2Weight = .2f
    val column3Weight = .2f

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(16.dp)) {
            // header
            item {
                Row(
                    Modifier.background(Color.Gray),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TableCell(text = "Spelare", weight = column1Weight)
                    TableCell(text = "Poäng", weight = column2Weight)
                    TableCell(text = "Antal vinster", weight = column2Weight)
                }
            }

            val sortedPlayers = playersState.players.sortedByDescending { it.score }
            // rows
            items(sortedPlayers) { player ->
                Row(Modifier.fillMaxWidth()) {
                    TableCell(text = player.playerName.uppercase(), weight = column1Weight)
                    TableCell(text = player.score.toString(), weight = column2Weight)
                    TableCell(text = player.wins.toString(), weight = column3Weight)
                }
            }
        }

        Button(
            onClick = { navController.navigate(Screen.NewGameScreen.route)},
            modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),

            ) {
            Text(text = "Nytt spel")
        }
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .weight(weight)
            .padding(8.dp),
        fontSize = 25.sp,
        textAlign = TextAlign.Center
    )
}