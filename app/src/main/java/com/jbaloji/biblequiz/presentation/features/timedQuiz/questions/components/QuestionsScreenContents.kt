package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun QuestionsScreenContents(
    currentQuestion: String,
    hint: String,
    answer: String,
    options: List<String>,
    currentScore: Int,
    currentQuestionNumber: Int,
    time: Int,
    progress: Float,
    totalQuestions: Int,
    totalHints: Int,
    isLastQuestion: Boolean,
    hasAnswered: Boolean,
    toggleDialog : () -> Unit,
    nextOrFinish : () -> Unit,
    onNavigateToScore : () -> Unit
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .padding(10.dp,0.dp)

        ) {
            Box(modifier = Modifier
                .weight(0.1f)
            ) {
                QuestionNumberText(
                    currentQuestion = currentQuestionNumber,
                    totalQuestions = totalQuestions,
                    maxHints = totalHints,
                    totalScore = currentScore
                )

            }
            Box(modifier = Modifier.weight(0.1f)) {
                CountDown(
                    time = time,
                    progress = progress
                )

            }
            Box(modifier = Modifier.weight(0.3f)) {
                QuestionText(currentQuestion)

            }
            Box(modifier = Modifier.weight(0.1f)) {
                HintText(
                    hintText = hint,
                )

            }
            Box(modifier = Modifier.weight(0.5f)){
                AnswerButtonContainer(
                    options = options,
                    answer = answer,
                )}
            Box(modifier = Modifier.weight(0.1f)) {
                MiscButtonContainer(
                    hasAnswered = hasAnswered,
                    isLastQuestion = isLastQuestion,
                    nextOrFinish = { nextOrFinish()
                    },
                    toggleQuitMenu = toggleDialog
                    ,
                    onNavigateToScore = { onNavigateToScore()
                    }
                )

            }

        }

    }
}
