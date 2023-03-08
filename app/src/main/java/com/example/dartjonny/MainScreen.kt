package com.example.dartjonny

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "DartJonny",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(20.dp),
            backgroundColor = Color(139, 137, 137, 255),
            elevation = 2.dp
        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .height(60.dp)
                        .fillMaxWidth()
                        .background(Color(255, 85, 0))
                        .clickable(onClick = { navController.navigate(Screen.NewGameScreen.route) }),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text = "Nytt spel", modifier = Modifier.padding(start = 20.dp))
                    Spacer(modifier = Modifier.width(width = 90.dp))
                    Image(
                        painter = painterResource(id = R.drawable.minidart),
                        contentDescription = "",
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.height(height = 20.dp))

                Row(
                    modifier = Modifier
                        .padding(all = 10.dp)
                        .height(60.dp)
                        .fillMaxWidth()
                        .background(Color.White)
                        .clickable(onClick = { navController.navigate(Screen.EndOfGameScreen.route) }),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = "Leaderboard",
                        modifier = Modifier.padding(start = 20.dp),
                    )
                    Spacer(modifier = Modifier.width(width = 65.dp))
                    Image(
                        painter = painterResource(id = R.drawable.leaderboard),
                        contentDescription = "",
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}