package com.jbaloji.biblequiz.presentation.features.timedQuiz.levels.components

import LevelsScreenContents
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.domain.model.Response.*
import com.jbaloji.biblequiz.presentation.features.timedQuiz.levels.LevelsViewModel

@Composable
fun ScoreData(
    navController: NavController,
    vm: LevelsViewModel = hiltViewModel(),
){
    when(val scoreData = vm.scoreDataResponse){
        is Loading -> LevelShimmer()
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