package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AnswerButtonContainer(
    options: List<String>, answer: String
){

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()

    ) {

        for(option in options){
            AnswerButton(
                option = option,
                answer = answer,
            )
        }

    }


}












