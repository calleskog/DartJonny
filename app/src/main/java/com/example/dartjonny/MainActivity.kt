package com.example.dartjonny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.dartjonny.dart_jonny.presentation.player.AddNewPlayerModel
import com.example.dartjonny.ui.theme.DartJonnyTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AddNewPlayerModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DartJonnyTheme {
                Navigation(viewModel)
            }
        }
    }
}