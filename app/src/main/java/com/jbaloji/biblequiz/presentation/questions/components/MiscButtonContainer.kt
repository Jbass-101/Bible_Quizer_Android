package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun MiscButtonContainer(
    hasAnswered: Boolean,
    nextQuestion: () ->  Unit,
    quitGame: () -> Unit
){
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth(1f)
        ){


            TextButton(onClick = quitGame) {
                Text(text = "Quit Quiz")

            }
            Button(

                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp),
                enabled = hasAnswered,

                onClick = nextQuestion
            ) {
                Text(text = "next")

            }
        }



}


