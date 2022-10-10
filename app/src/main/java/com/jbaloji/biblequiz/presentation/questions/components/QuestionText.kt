package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jbaloji.biblequiz.R

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