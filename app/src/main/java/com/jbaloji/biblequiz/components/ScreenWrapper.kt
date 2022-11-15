package com.jbaloji.biblequiz.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun ScreenWrapper(
    content : @Composable () -> Unit
){
    BibleQuizTheme {
        Scaffold(
            backgroundColor = MaterialTheme.colors.background
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
            ){
               content()
            }

        }

    }

}