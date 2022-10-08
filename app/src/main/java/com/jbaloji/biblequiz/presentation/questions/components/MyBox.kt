package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

@Composable
fun MyBox(height :Float, content : @Composable () -> Unit){
    Box(
        modifier = Modifier
            .fillMaxHeight(height)
            .fillMaxWidth(1f),) {
        content
    }

}