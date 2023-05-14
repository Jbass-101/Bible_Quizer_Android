package com.jbaloji.biblequiz.presentation.features.timedQuiz.levels.components

import LevelsScreenContents
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.components.ProgressBar
import com.jbaloji.biblequiz.domain.model.Response.*
import com.jbaloji.biblequiz.presentation.features.timedQuiz.levels.LevelsViewModel

@Composable
fun ScoreData(
    navController: NavController,
    vm: LevelsViewModel = hiltViewModel(),
){
    when(val scoreData = vm.scoreDataResponse){
        is Loading -> ProgressBar()
        is Success -> scoreData.apply {
            LevelsScreenContents(
                navController = navController ,
                score = data )
        }
        is Failure -> scoreData.apply {
            vm.initScoreData()
        }
    }

}