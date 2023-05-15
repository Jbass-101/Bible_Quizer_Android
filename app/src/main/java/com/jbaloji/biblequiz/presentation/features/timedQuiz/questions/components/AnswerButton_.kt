package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.theme.Shapes

@Composable
fun AnswerButton_(
    option: String,
    answer: String,
    hasAnswered: Boolean,
    answerQuestion: (Boolean) -> Unit,
){
    val correct = (answer == option)

    //correct Answer
    if(hasAnswered && correct){
        TextButton(
            modifier = Modifier
                .fillMaxWidth(1f)
                .border(1.dp, MaterialTheme.colorScheme.secondary, Shapes.medium),
            enabled = false,
            onClick = {
            },
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    text = option,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        )
    //Incorrect Answer
    } else if(hasAnswered){
        TextButton(
            modifier = Modifier
                .fillMaxWidth(1f)
                .border(1.dp, MaterialTheme.colorScheme.error, Shapes.medium),
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
        TextButton(
            modifier = Modifier
                .fillMaxWidth(1f)
                .border(1.dp, MaterialTheme.colorScheme.onSurface, Shapes.medium),
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





