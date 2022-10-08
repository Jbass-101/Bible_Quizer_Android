package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import com.jbaloji.biblequiz.R

@Composable
fun HintAndExplanationText(){
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxHeight(0.15f)
            .fillMaxWidth(1f)) {

        Text(text = "Explanation : In the Beginning was the word, and the word was god, and it was good")
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Hint : Genesis 1:1")
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Show Hint")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "Show Hint")
            }
        }

    }
}