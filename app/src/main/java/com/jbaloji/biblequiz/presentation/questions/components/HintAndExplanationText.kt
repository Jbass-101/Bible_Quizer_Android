package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.jbaloji.biblequiz.R

@Composable
fun HintAndExplanationText(
    hintText: String, explanation: String,
    isHint: Boolean,
    showHint: () -> Unit
){
    var localHintText = ""
    if(isHint){
        localHintText ="Hint: $hintText"
    }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxHeight(0.2f)
            .fillMaxWidth(1f)) {

        Text(text = "Explanation : $explanation")
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Text(text = localHintText)
            TextButton(onClick = showHint) {
                Text(text = "Show Hint")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "Show Hint")
            }
        }

    }
}