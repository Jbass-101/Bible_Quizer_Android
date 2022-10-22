package com.jbaloji.biblequiz.presentation.score

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ScoreScreen (
    onNavigateToHome: () -> Unit,
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        Text(text = "This is the score screen")
        Button(onClick = onNavigateToHome ) {
            Text(text = "Home Screen")

        }

    }
}