package com.example.dartjonny

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AddNewPlayerModel : ViewModel() {
    var isDialogShown by mutableStateOf(false)

    fun onAddPlayerClick() {
        isDialogShown = true
    }

    fun onDissmissDialog() {
        isDialogShown = false
    }
}