package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.QuestionsViewModel

@Composable
fun CountDown(
    vm: QuestionsViewModel = hiltViewModel(),
    time: Int,
    progress : Float)
{
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
    ) {
        //ICON
        Icon(painter = painterResource(id = R.drawable.ic_timer),
            contentDescription = "Count Down Timer")
        //Progress Bar
        LinearProgressIndicator(
            progress = animateFloatAsState(
                targetValue = vm.currentProgress,
                animationSpec = tween(
                    durationMillis = 1100,
                    easing = EaseOut
                )
            ).value,
            color = when(vm.currentTime){
                60 -> animateColorAsState(
                    targetValue = Color.Green,
                    animationSpec = tween(
                        durationMillis = 1000,
                        easing = LinearEasing
                    ),
                ).value
                else -> animateColorAsState(
                    targetValue = if(vm.currentTime < 55) Color.Red else Color.Green,
                    animationSpec = tween(
                        durationMillis = 54000,
                        easing = LinearEasing
                    ),
                ).value
            }
        )
        //TEXT TIME
        Text(text = time.toString() )

    }

}