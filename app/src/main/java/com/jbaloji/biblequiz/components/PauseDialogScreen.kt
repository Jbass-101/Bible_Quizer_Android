package com.jbaloji.biblequiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.jbaloji.biblequiz.presentation.home.components.GenericButton
import com.jbaloji.biblequiz.presentation.theme.Overlay

@Composable
fun PauseDialogScreen(
    onBack: () -> Unit,
    onNavigateToLobby: () -> Unit,
    onNavigateToLevels : () -> Unit
){

//    Popup(
//            alignment = Alignment.Center,
//        properties = PopupProperties(
//            focusable = true
//        ),
//        onDismissRequest = onBack
//
//    )
//    {
        Card(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
//                        .fillMaxWidth(0.8f)
//                        .fillMaxHeight(0.3f)
                    .fillMaxSize()

                    .background(color = Overlay)
            ) {
                GenericButton(
                    text = "Continue" ,
                    action = onBack
                )
                GenericButton(
                    text = "Levels" ,
                    action = onNavigateToLevels
                )
                GenericButton(
                    text = "Main menu",
                    action = onNavigateToLobby
                )

            }

        }

//    }

}