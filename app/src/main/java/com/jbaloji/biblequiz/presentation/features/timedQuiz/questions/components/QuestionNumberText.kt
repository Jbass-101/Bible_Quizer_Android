package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun QuestionNumberText(
    currentQuestion: Int, totalQuestions: Int,
    maxHints: Int,totalScore: Int
){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Text(
            text = "Score: $totalScore")
        Text(
            text = "Question $currentQuestion/$totalQuestions")
        Text(
            text = "Hints: $maxHints")
    }
}