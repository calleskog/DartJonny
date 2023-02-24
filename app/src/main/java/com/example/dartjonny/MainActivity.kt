package com.example.dartjonny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dartjonny.ui.theme.DartJonnyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DartJonnyTheme {
                DefaultPreview()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DartJonnyTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,

        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Nytt spel")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Alternativ")
            }
        }
    }
}