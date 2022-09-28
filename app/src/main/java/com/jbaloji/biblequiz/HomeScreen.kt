package com.jbaloji.biblequiz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.jbaloji.biblequiz.ui.theme.BibleQuizTheme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibleQuizTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(Message("Android","jectpack Compose"))
                }
            }
        }
    }
}

data class Message(val author: String, val body: String)



@Composable
fun Greeting(msg: Message) {
    Row() {
        Image(painter = painterResource(id = R.drawable.profile_picture),
            contentDescription ="Contact Profile Picture" )

    }
    Column() {
        Text(text = msg.author)
        Text(text = msg.body)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BibleQuizTheme {
        Greeting(Message("Junior","Cool this JetPack is not bad at all"))
    }
}