package com.jbaloji.biblequiz.presentation.features.timedQuiz.score

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.presentation.features.timedQuiz.score.components.ScoreScreenContents


@Composable
fun ScoreScreen (
    onNavigateToHome: () -> Unit,
    onNavigateToLevels: () -> Unit,
    vm: ScoreScreenViewModel =  hiltViewModel()
){
    ScoreScreenContents(
        score = vm.currentScore,
        onNavigateToHome = onNavigateToHome,
        onNavigateToLevels = onNavigateToLevels,
    )
}


