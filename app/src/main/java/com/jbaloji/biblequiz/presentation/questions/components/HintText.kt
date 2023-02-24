package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.presentation.questions.QuestionsViewModel

@Composable
fun HintText(
    viewModel: QuestionsViewModel = hiltViewModel(),
    hintText: String,
){

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth(1f)
    ) {

        if(!viewModel.hasAnswered && !viewModel.isHint){
            Text(text = "")
        } else {
            Text(text = hintText)
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