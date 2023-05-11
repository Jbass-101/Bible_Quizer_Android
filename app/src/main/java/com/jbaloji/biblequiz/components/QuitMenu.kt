package com.jbaloji.biblequiz.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
fun QuitMenu(
    toggleQuitMenu: () -> Unit,
    onNavigateToHome: () -> Unit

){
    Popup(
        alignment = Alignment.Center,
        properties = PopupProperties(
            focusable = true
        ),
        onDismissRequest = toggleQuitMenu
    )
     {
        Card() {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
//                .fillMaxWidth(0.8f)
//                .fillMaxHeight(0.3f)
                    .fillMaxSize()

            ) {
                Text(text = "Quit Bible Quiz?")
                Spacer(modifier = Modifier.padding(15.dp))
                Button(
                    onClick = toggleQuitMenu
                ) {
                    Text(text = "Continue")

                }
                Button(
                    onClick = onNavigateToHome
                ) {
                    Text(text = "Quit to main menu")

                }

            }

        }

    }

}
