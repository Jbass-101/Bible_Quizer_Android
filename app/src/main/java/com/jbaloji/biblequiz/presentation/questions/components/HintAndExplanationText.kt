package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.presentation.questions.QuestionsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HintAndExplanationText(
    viewModel: QuestionsViewModel = hiltViewModel(),
    hintText: String, explanation: String,
){

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth(1f)) {

        if (!viewModel.hasAnswered){
            Text(text = "")
        } else {
            Text(text = "Explanation: $explanation")
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(1f)
        ) {

            if(!viewModel.hasAnswered && !viewModel.isHint){
                Text(text = "")
            } else {
                Text(text = "Reference: $hintText")
            }

            TextButton(onClick = {
                viewModel.showHint()
            }) {
                Text(text = "Show Hint")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "Show Hint")
            }
        }

    }
}