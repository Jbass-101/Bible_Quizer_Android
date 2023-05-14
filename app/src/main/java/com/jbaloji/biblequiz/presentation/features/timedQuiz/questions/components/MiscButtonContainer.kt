package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MiscButtonContainer(
    hasAnswered: Boolean,
    isLastQuestion: Boolean,
    nextOrFinish: () ->  Unit,
    toggleQuitMenu: () -> Unit,
    onNavigateToScore: () -> Unit
){
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ){


            TextButton(onClick = toggleQuitMenu ) {
                Text(text = "Quit Quiz")

            }
            Button(
                modifier = Modifier
                    .width(100.dp)
                    .height(50.dp),
                enabled = hasAnswered,

                onClick = if (isLastQuestion){
                    onNavigateToScore
                }else {
                    nextOrFinish
                }
            ) {
                if (isLastQuestion){
                    Text(text = "Finish")
                } else {
                    Text(text = "Next")

                }

            }
        }

}


