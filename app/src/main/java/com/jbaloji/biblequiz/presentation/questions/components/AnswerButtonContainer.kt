package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R

@Composable
fun AnswerButtonContainer(){

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.8f)

    ) {

        AnswerButton(stringResource(id = R.string.Sample_Answer_1))

        AnswerButton(stringResource(id = R.string.Sample_Answer_2))

        AnswerButton(stringResource(id = R.string.Sample_Answer_3))

        AnswerButton(stringResource(id = R.string.Sample_Answer_4))
    }


}












