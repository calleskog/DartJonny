package com.example.dartjonny.dart_jonny.presentation.playGame

import androidx.lifecycle.ViewModel
import com.example.dartjonny.dart_jonny.useCases.newGame.NewGameUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayGameViewModel @Inject constructor(
    private val newGameUseCases: NewGameUseCases
): ViewModel() {

}