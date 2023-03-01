package com.example.dartjonny.dart_jonny.presentation.options

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.dartjonny.Screen

@Composable
fun OptionsScreen(
    navController: NavController,
    viewModel: OptionsViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = {
                    navController.navigate(Screen.MainScreen.route)
                }
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                Text(text = "Tillbaka")
            }

            Text(
                text = "Spel inställning",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(end = 18.dp)
            )
        }
        InputField()
    }
}

@Composable
fun InputField(
    text: String = "",
    length: Int = 8,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
) {
    val BoxHeight = 40.dp
    val BoxWidth = 40.dp
    var textValue by remember { mutableStateOf(text) }


    BasicTextField(
        value = textValue,
        singleLine = true,
        onValueChange = {
            textValue = it
        },
        keyboardOptions = keyboardOptions,
        decorationBox = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                repeat(length) {
                    Text(
                        text = textValue,
                        modifier = Modifier
                            .size(
                                width = BoxWidth,
                                height = BoxHeight
                            )
                            .clip(RoundedCornerShape(4.dp))
                            .border(width = 1.dp, color = Color.Black)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    )
}