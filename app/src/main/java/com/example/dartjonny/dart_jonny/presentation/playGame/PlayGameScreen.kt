package com.example.dartjonny.dart_jonny.presentation.playGame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.Screen
import com.example.dartjonny.dart_jonny.presentation.addPlayer.components.PlayerItem


@Composable
fun PlayGameScreen(
    navController: NavController
) {
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

        Box(
            modifier = Modifier
                .weight(3f)
                .fillMaxSize()
        ) {
            Row(modifier = Modifier.fillMaxSize().padding(5.dp)) {
                Button(modifier = Modifier
                    .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
                Box(modifier = Modifier.weight(2f)) {

                }
                Button(modifier = Modifier
                    .weight(1f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Next")
                }
            }
        }
    }
}

