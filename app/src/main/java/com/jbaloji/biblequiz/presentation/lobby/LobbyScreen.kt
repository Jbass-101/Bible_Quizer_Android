package com.jbaloji.biblequiz.presentation.lobby


import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.jbaloji.biblequiz.domain.model.Feature
import com.jbaloji.biblequiz.presentation.lobby.components.LobbyScreenContents

@Composable
fun LobbyScreen(
    onNavigateToLevels: () -> Unit,
    onNavigateToHome : () -> Unit,
    onNavigateToContents : () -> Unit,
){

    LobbyScreenContents(
        onNavigateToHome = onNavigateToHome,
        feature = listOf(
            Feature(
                name = stringResource(id = com.jbaloji.biblequiz.R.string.mode_timed_quiz),
                icon = com.jbaloji.biblequiz.R.drawable.timer_icon_200,
                onClick = onNavigateToLevels
            ),
            Feature(
                name = stringResource(id = com.jbaloji.biblequiz.R.string.mode_study_basics),
                icon = com.jbaloji.biblequiz.R.drawable.baseline_menu_book_24,
                onClick = onNavigateToContents
            ),
        )
    )

}