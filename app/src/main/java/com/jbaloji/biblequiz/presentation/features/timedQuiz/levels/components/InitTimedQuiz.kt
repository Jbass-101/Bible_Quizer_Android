package com.jbaloji.biblequiz.presentation.features.timedQuiz.levels.components

import LevelsScreenContents
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.components.ProgressBar
import com.jbaloji.biblequiz.domain.model.Response.*
import com.jbaloji.biblequiz.domain.model.TimedQuizScore
import com.jbaloji.biblequiz.presentation.features.timedQuiz.levels.LevelsViewModel

@Composable
fun InitTimedQuiz(
    navController: NavController,
    vm: LevelsViewModel = hiltViewModel(),
    showErrorMessage: (errorMessage: String?) -> Unit
){

    when(val initQuiz = vm.initTimedQuizResponse){
        is Loading -> ProgressBar()
        is Success -> initQuiz.apply {
            if(data){
                LevelsScreenContents(
                    navController = navController ,
                    quizScore = TimedQuizScore() )
            }
        }
        is Failure -> initQuiz.apply {
            LaunchedEffect(e){
                showErrorMessage(e?.message)
            }
        }
    }

}