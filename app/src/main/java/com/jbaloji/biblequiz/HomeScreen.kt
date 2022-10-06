package com.jbaloji.biblequiz

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.presentation.questions.Components.DefaultButton
import com.jbaloji.biblequiz.presentation.questions.Components.TitleText

@Composable
fun HomeScreen(){

    Scaffold(
    ) {
        Column (
            modifier = Modifier
            //.background(color = colorResource(id = R.color.purple_200))
        ){
            Box(
                modifier = Modifier
                    //.background(color = colorResource(id = R.color.teal_200))
                    .fillMaxWidth(1f)
                    .heightIn(450.dp),
                contentAlignment = Alignment.Center

            ) {
                TitleText()
            }
            Box(
                modifier = Modifier
                    //.background(color = colorResource(id = R.color.teal_200))
                    .fillMaxWidth(1f)
                    .heightIn(450.dp),
                contentAlignment = Alignment.Center

            ) {
                DefaultButton(text = "Start")
            }

        }
    }
}