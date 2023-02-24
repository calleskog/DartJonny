package com.example.dartjonny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dartjonny.ui.theme.DartJonnyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DartJonnyTheme {
                Navigation()
            }
        }
    }
}