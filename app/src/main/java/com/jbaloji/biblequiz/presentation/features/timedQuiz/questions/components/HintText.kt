package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.QuestionsViewModel

@Composable
fun HintText(
    viewModel: QuestionsViewModel = hiltViewModel(),
    hintText: String,
){

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
    ) {

        TextButton(onClick = {
            viewModel.showHint()
        }) {
            Icon(painter = painterResource(id = R.drawable.ic_info),
                contentDescription = "Show Hint")
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Show Hint")
        }
        AnimatedVisibility(visible = viewModel.hasAnswered || viewModel.isHint) {
            Text(text = hintText)
        }
    }
}