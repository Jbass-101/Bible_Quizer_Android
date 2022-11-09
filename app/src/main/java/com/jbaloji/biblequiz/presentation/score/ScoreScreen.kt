package com.jbaloji.biblequiz.presentation.score

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun ScoreScreen (
    onNavigateToHome: () -> Unit,
    viewModel: ScoreScreenViewModel =  hiltViewModel()
){
    BibleQuizTheme() {
        Scaffold(
            backgroundColor = MaterialTheme.colors.background,
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize(1f)
                    .padding(it)
            ) {
                Text(text = "Demo Complete")
                Spacer(modifier = Modifier.padding(15.dp))
                Button(onClick = onNavigateToHome ) {
                    Text(text = "Home")

                }

            }

        }

    }
}