package com.jbaloji.biblequiz.presentation.lobby


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.domain.model.Feature
import com.jbaloji.biblequiz.presentation.lobby.components.LobbyScreenContents

@Composable
fun LobbyScreen(
    onNavigateToLevels: () -> Unit,
    onNavigateToHome : () -> Unit,
    viewModel: LobbyViewModel = hiltViewModel()
){

    LobbyScreenContents(
        onNavigateToHome = onNavigateToHome,
        feature = listOf(
            Feature(
                name = "Timed Quiz",
                icon = com.jbaloji.biblequiz.R.drawable.timer_icon_200,
                onClick = onNavigateToLevels
            )
        )
    )

}