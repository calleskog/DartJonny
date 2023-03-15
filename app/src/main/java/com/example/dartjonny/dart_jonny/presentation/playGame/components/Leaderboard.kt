package com.example.dartjonny.dart_jonny.presentation.playGame.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dartjonny.dart_jonny.model.Player

@Composable
fun Leaderboard(
    player: Player,
    currentPlayer: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = player.playerName.uppercase(),
            color = if (currentPlayer) Color(255, 85, 0) else Color.White,
            fontSize = (if (currentPlayer) 45.sp else 20.sp),
            maxLines = 1,
            fontWeight = (if (currentPlayer) FontWeight.Bold else FontWeight.Normal)
        )
        Text(text = player.score.toString(),
            fontSize = (if (currentPlayer) 45.sp else 20.sp),
            color = if (currentPlayer) Color(255, 85, 0) else Color.White,
            fontWeight = (if (currentPlayer) FontWeight.Bold else FontWeight.Normal)
        )
    }
}