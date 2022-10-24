package com.jbaloji.biblequiz.presentation.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun GenericButton (
    text: String,
    action : () -> Unit,
    enabled : Boolean = true
){
    Button(
        modifier = Modifier.fillMaxWidth(0.5f),
        onClick = action,
        enabled = enabled
    ) {
        Text(text = text)
        
    }

}

