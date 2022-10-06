package com.jbaloji.biblequiz.presentation.questions

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun QuestionsScreen(
    viewModel: QuestionsViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
                 TopAppBar (
                     title = {
                         Text(text = "Serious is the title")
                     }
                         )
        },
        content = {paddingValues ->

            Button(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth(1f),

                onClick ={  viewModel.getBooks() }
            ) {
                Text(
                    color = Color.Red,
                    text = "Button Here")
            }

        }

    )

}
