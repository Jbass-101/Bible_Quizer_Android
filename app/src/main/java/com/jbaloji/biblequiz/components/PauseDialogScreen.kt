package com.jbaloji.biblequiz.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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