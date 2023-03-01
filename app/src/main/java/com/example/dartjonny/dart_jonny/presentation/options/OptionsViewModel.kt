package com.example.dartjonny.dart_jonny.presentation.options

import androidx.lifecycle.ViewModel
import com.example.dartjonny.dart_jonny.useCases.newGame.NewGameUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OptionsViewModel @Inject constructor(
    private val newGameUseCases: NewGameUseCases
): ViewModel() {

}