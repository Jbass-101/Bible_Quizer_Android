package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuestionNumberText(
    currentQuestion: Int, totalQuestions: Int,
    maxHints: Int,totalScore: Int
){

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(0.dp,5.dp,0.dp,0.dp)
            .fillMaxHeight(0.05f)
            .fillMaxWidth(1f),) {
        Text(
            fontSize = 20.sp,
            text = "Score: $totalScore")
        Text(
            fontSize = 20.sp,
            text = "Question $currentQuestion/$totalQuestions")
        Text(
            fontSize = 20.sp,
            text = "Hints: $maxHints")
    }

}