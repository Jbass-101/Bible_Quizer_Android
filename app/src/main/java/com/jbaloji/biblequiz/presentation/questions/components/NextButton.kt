package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NextButton(){

    Button(

        modifier = Modifier
            .width(100.dp)
            .height(50.dp),

        onClick = { /*TODO*/ }) {
        Text(text = "next")

    }
}