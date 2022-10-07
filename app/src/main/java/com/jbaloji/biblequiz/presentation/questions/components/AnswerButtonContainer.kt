package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R

@Composable
fun AnswerButtonContainer(){

    Column {

        //AnswerButton()
        AnswerButton(stringResource(id = R.string.Sample_Answer_1))
        MySpacer()
        AnswerButton(stringResource(id = R.string.Sample_Answer_2))
        MySpacer()
        AnswerButton(stringResource(id = R.string.Sample_Answer_3))
        MySpacer()
        AnswerButton(stringResource(id = R.string.Sample_Answer_4))
    }


}












