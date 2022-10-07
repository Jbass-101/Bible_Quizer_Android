package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.jbaloji.biblequiz.R

@Composable
fun QuestionText() {
    Text(
        modifier = Modifier.fillMaxWidth(1f),
        textAlign = TextAlign.Center,


        text = stringResource(id = R.string.sampleQuestion))

}