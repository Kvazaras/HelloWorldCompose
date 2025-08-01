package com.example.helloworldcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworldcompose.ui.theme.HelloWorldComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                    MainContentScreen()
                }
            }
        }
    }
}

@Composable
fun MainContentScreen() {
    var lblChangeTextValue by remember { mutableStateOf("Hello world") }
    var lblChangeColor by remember { mutableStateOf(Color.Black) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = lblChangeTextValue)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Hello color",
             color = lblChangeColor)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { lblChangeTextValue = "Text Changed. Yey!" }) {
            Text("Change Text")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { lblChangeColor = Color.Red }) {
            Text("Change Color")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            lblChangeColor = when (lblChangeColor) {
                Color.Black -> Color.Red
                Color.Red -> Color.Blue
                Color.Blue -> Color.Green
                else -> Color.Black
            }
        }) {
            Text("Change Random Color")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContentScreen()
}