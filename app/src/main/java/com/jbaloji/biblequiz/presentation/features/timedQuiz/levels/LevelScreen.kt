package com.jbaloji.biblequiz.presentation.features.timedQuiz.levels

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.presentation.features.timedQuiz.levels.components.InitTimedQuiz
import com.jbaloji.biblequiz.presentation.features.timedQuiz.levels.components.ScoreData

@Composable
fun LevelsScreen(
    navController: NavController,
    viewModel: LevelsViewModel = hiltViewModel()
){

    val context = LocalContext.current
    
    ScoreData(
        navController = navController
    )

    InitTimedQuiz(
        navController = navController,
        showErrorMessage = {
            errorMessage ->
        Utils.showMessage(context,errorMessage)
    })


}