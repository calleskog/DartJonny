package com.example.dartjonny.dart_jonny.presentation.playGame.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = player.playerName.uppercase(),
            fontSize = (if (currentPlayer) 25.sp else 17.sp),
            maxLines = 1,
            fontWeight = (if (currentPlayer) FontWeight.Bold else FontWeight.Normal)
        )
        Text(text = player.score.toString(),
            fontSize = 20.sp,
            fontWeight = (if (currentPlayer) FontWeight.Bold else FontWeight.Normal)
        )
    }
}