package com.jbaloji.biblequiz.presentation.home.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.jbaloji.biblequiz.R

@Composable
fun TitleText(){
    Text(
        text = stringResource(id = R.string.app_name),
        fontSize = 40.sp,
        color = MaterialTheme.colors.primary

    )

}

