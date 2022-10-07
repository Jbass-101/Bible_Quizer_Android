package com.jbaloji.biblequiz.presentation.questions.components

import android.widget.ProgressBar
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuestionNumberText() {
    Text(
        fontSize = 20.sp,
        modifier = Modifier.fillMaxWidth(1f),
        textAlign = TextAlign.Center,
        text = "Question 1/20")
    MySpacer()
    LinearProgressIndicator(
        modifier = Modifier.fillMaxWidth(1f),
        progress = 0.5f)

}