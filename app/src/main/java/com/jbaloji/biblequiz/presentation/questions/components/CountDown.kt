package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.jbaloji.biblequiz.R

@Composable
fun CountDown(
    time: Int,
    progress : Float)
{
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxHeight(0.05f)
            .fillMaxWidth(1f)


    ) {
        //ICON
        Icon(painter = painterResource(id = R.drawable.ic_timer),
            contentDescription = "Count Down Timer")
        Spacer(Modifier.width(ButtonDefaults.IconSpacing))
        //Progress Bar
        LinearProgressIndicator(
            progress = animateFloatAsState(
                targetValue = progress,
                animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
            ).value
        )


        //TEXT TIME
        Spacer(Modifier.width(ButtonDefaults.IconSpacing))
        Text(text = time.toString() )

    }

}