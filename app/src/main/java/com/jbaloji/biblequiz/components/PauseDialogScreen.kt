package com.jbaloji.biblequiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.jbaloji.biblequiz.presentation.theme.Overlay

@Composable
fun PauseDialogScreen(
    onBack: () -> Unit,
    onNavigateToLevels: () -> Unit
){
    Popup(
        alignment = Alignment.Center,
        properties = PopupProperties(
            focusable = true
        ),
        onDismissRequest = onBack
    )
    {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.3f)

                .background(color = Overlay)
        ) {
            Text(text = "Quit Bible Quiz?")
            Spacer(modifier = Modifier.padding(15.dp))
            Button(
                onClick = onBack
            ) {
                Text(text = "Continue")

            }
            Button(
                onClick = onNavigateToLevels
            ) {
                Text(text = "Quit to main menu")

            }

        }

    }

}