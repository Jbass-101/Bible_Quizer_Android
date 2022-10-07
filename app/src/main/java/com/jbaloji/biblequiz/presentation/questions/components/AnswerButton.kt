package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.presentation.theme.Shapes

@Composable
fun AnswerButton(
    text : String
){


    TextButton(
        modifier = Modifier
            .fillMaxWidth(1f)
            .border(1.dp, Color.DarkGray, shape = Shapes.medium),

        onClick = { /*TODO*/ },
        content = {
            AnswerButtonText(text = text)
        }
    )

}





