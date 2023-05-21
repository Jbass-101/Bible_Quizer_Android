package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AnswerButton(
    option: String,
    answer: String,
    hasAnswered: Boolean,
    answerQuestion: (Boolean) -> Unit,
){
    val correct = (answer == option)

    //correct Answer
    if(hasAnswered && correct){
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth(1f),
//                .border(1.dp, MaterialTheme.colorScheme.secondary, Shapes.medium),
            border = BorderStroke(1.dp,MaterialTheme.colorScheme.onSurface),
            enabled = false,
            onClick = {
            },
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    text = option,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        )
    //Incorrect Answer
    } else if(hasAnswered){
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth(1f),
//                .border(1.dp, MaterialTheme.colorScheme.error, Shapes.medium),
            border = BorderStroke(1.dp,MaterialTheme.colorScheme.error),
            enabled = false,
            onClick = {
            },
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    text = option,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.error
                )
            }
        )
    //Default
    } else {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth(1f),
//                .border(1.dp, MaterialTheme.colorScheme.onSurface, Shapes.medium),
            onClick = {
                      answerQuestion(correct)
            },
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = option,
                    textAlign = TextAlign.Center,
                )
            }
        )

    }
}





