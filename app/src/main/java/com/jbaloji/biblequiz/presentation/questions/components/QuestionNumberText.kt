package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun QuestionNumberText(
    currentQuestion: Int, totalQuestions: Int,
    maxHints: Int,totalScore: Int
){

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
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