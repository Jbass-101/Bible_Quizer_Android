package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import com.jbaloji.biblequiz.R

@Composable
fun ExplanationText() {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.ic_info), contentDescription = "Show Explanation")

        }
    }
}