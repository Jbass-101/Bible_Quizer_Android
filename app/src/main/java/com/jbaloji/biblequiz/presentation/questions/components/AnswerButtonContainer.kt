package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AnswerButtonContainer(
    options: List<String>, answer: String
){

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.8f)

    ) {

        for(option in options){
            AnswerButton(
                option = option,
                answer = answer,
            )
        }

    }


}












