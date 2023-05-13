package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.QuestionsViewModel
import com.jbaloji.biblequiz.theme.Shapes

@Composable
fun AnswerButton(
    viewModel: QuestionsViewModel = hiltViewModel(),
    option: String, answer: String,
){
    val correct = answer == option
    val hasAnswered = viewModel.hasAnswered

    //correct Answer
    if(hasAnswered && correct){
        TextButton(
            modifier = Modifier
                .fillMaxWidth(1f)
                .border(1.dp, Color.Green, Shapes.medium),
            enabled = !hasAnswered,
            onClick = {
            },
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    text = option,
                    textAlign = TextAlign.Start,
                    color = Color.Green
                )
            }
        )
    //Incorrect Answer
    } else if(hasAnswered && !correct){
        TextButton(
            modifier = Modifier
                .fillMaxWidth(1f)
                .border(1.dp, Color.Red, Shapes.medium),
            enabled = !hasAnswered,
            onClick = {
            },
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    text = option,
                    textAlign = TextAlign.Start,
                    color = Color.Red
                )
            }
        )
    //Default
    } else {
        TextButton(
            modifier = Modifier
                .fillMaxWidth(1f)
                .border(1.dp, Color.DarkGray, Shapes.medium),
            enabled = !hasAnswered,
            onClick = {
                      viewModel.answerQuestion(correct)
            },
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    text = option,
                    textAlign = TextAlign.Start,
                    // color = Color.Green
                )
            }
        )

    }




}





