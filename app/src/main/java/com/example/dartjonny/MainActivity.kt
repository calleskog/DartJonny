package com.example.dartjonny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.dartjonny.dart_jonny.presentation.player.AddNewPlayerModel
import com.example.dartjonny.ui.theme.DartJonnyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DartJonnyTheme {
                Navigation(viewModel)
            }
        }
    }
}