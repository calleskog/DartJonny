package com.example.dartjonny.dart_jonny.presentation.completedGame

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
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
fun EndOfGameScreen(
    navController: NavController,
    viewModel: DartViewModel = hiltViewModel()
) {
    val playersState = viewModel.players.value

    val column1Weight = .2f
    val column2Weight = .2f
    val column3Weight = .2f

    Box(modifier = Modifier.fillMaxSize().background(Color(218, 196, 189, 255))) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(16.dp)) {
            // header
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TableCell(text = "Spelare", weight = column1Weight, 700)
                    TableCell(text = "Poäng", weight = column2Weight, 700)
                    TableCell(text = "Antal vinster", weight = column2Weight, 700)
                }
                Divider(color = Color.Black, thickness = 1.dp, )
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


        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color(40,40,40))
                .height(60.dp)
                .clickable(onClick = { navController.navigate(Screen.NewGameScreen.route) }),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "NYTT SPEL", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
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