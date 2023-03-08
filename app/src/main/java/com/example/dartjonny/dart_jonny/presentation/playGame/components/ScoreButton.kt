package com.example.dartjonny.dart_jonny.presentation.playGame.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun ScoreButton(
    number: String,
    modifier: Modifier,
    onClick: () -> Unit,
    enabled: Boolean
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color(50,50,50))
            .clickable(onClick = onClick, enabled = enabled)
            .then(modifier)
    ) {
        Text(
            text = number,
            fontSize = 25.sp,
            color = Color.White
        )
    }
}