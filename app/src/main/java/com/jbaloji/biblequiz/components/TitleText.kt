package com.jbaloji.biblequiz.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.jbaloji.biblequiz.R

@Composable
fun TitleText(){
    Text(
        text = stringResource(id = R.string.app_name),
        fontSize = 40.sp,

    )

}

