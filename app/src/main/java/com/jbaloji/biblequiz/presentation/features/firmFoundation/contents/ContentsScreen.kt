package com.jbaloji.biblequiz.presentation.features.firmFoundation.contents

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ContentsScreen(){
    Column() {
        Text(text = "Contents Page")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Chapter 1")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Chapter 2")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Chapter 3")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Chapter 4")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Chapter 5")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Chapter 6")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Chapter 7")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Conclusion")

        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Home")

        }
    }

}

@Preview(name = "ContentsPage")
@Composable
fun ContentsScreenPreview(){
    ContentsScreen()
}

