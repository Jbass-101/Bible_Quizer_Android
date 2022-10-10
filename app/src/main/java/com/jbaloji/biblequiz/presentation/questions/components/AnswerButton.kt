package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.presentation.theme.Shapes

@Composable
fun AnswerButton(option: String,answer: String, hasAnswered: Boolean,
                 answerQuestion: (option:String,answer:String) -> Boolean
){
    var correct = false



    TextButton(
        modifier = Modifier
            .fillMaxWidth(1f)
            .border(1.dp,


                if(correct){

                    Color.Green
                }else {
                    Color.DarkGray
                },


                shape = Shapes.medium),
        enabled = !hasAnswered,

        onClick = {
                  correct = answerQuestion(option,answer)
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





