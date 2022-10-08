package com.jbaloji.biblequiz.presentation.questions.components

import android.widget.ProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jbaloji.biblequiz.R

@Composable
fun QuestionNumberText(){

    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight(0.05f)
            .fillMaxWidth(1f),) {
        Text(
            fontSize = 20.sp,
            text = "Question 1/20")
    }

}