package com.example.dartjonny.presentation.newGame

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AddNewPlayerModel : ViewModel() {
    var isDialogShown by mutableStateOf(false)
    var playerName by mutableStateOf("")

    fun onAddPlayerClick() {
        isDialogShown = true
    }

    fun onDissmissDialog() {
        isDialogShown = false
    }
}