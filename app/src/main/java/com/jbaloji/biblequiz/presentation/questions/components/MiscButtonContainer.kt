package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

@Composable
fun MiscButtonContainer(){
        Row (
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth(1f)
        ){

            QuitQuizButton()
            NextButton()
        }



}


