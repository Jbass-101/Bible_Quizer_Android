package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MiscButtonContainer(){
    Row (
        modifier = Modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.SpaceAround
            ){

        QuitQuizButton()
        NextButton()
    }

}


