package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MySpacer(){

    Spacer(
        modifier = Modifier
            .background(Color.Yellow, RectangleShape)
            .height(25.dp)
    )
}