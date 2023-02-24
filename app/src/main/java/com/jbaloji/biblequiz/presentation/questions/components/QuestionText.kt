package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun QuestionText(
    question: String

) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.3f),) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                fontSize = 19.sp,
                textAlign = TextAlign.Center,
                text = question
            )

        }
    }
}