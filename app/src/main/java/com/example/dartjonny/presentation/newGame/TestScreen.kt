package com.example.dartjonny.presentation.newGame

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.Screen
import java.lang.reflect.Modifier

@Composable
fun TestScreen(
    navController: NavController,
    viewModel: NewGameViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Spelare")

        Button(
            onClick = {
                navController.navigate(Screen.MainScreen.route)
            }
        ) {
            Text(text = "Tillbaka")
        }

        IconButton(
            onClick = {
                viewModel.onEvent(NewGameEvent.)
            }
        ) {
            Text(text = "Lägg till spelare")
            Icon(Icons.Default.Add, contentDescription = "Lägg till spelare")
        }
    }
}