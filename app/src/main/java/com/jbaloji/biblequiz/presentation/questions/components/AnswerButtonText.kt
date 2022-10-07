package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AnswerButtonText(text: String){

    Text(
        modifier = Modifier
            .fillMaxWidth(1f),
        text = text,
        textAlign = TextAlign.Start
    )
}