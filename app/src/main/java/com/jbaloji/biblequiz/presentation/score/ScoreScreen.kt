package com.jbaloji.biblequiz.presentation.score

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.presentation.home.components.GenericButton


@Composable
fun ScoreScreen (
    onNavigateToHome: () -> Unit,
    onNavigateToLevels: () -> Unit,
    viewModel: ScoreScreenViewModel =  hiltViewModel()
){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(1f)
    ) {
        Text(
            text = viewModel.currentScore.toString(),
            fontSize = 25.sp
        )
        Text(
            text = "Your Score"
        )
        Spacer(modifier = Modifier.padding(30.dp))
        if (viewModel.currentScore > 8){
            Text(text = "New level unlocked")
        }else {
            Text(text = "Score at least 9 to unlock the next level")
        }
        Spacer(modifier = Modifier.padding(15.dp))
        GenericButton(
            text = "Select Level",
            action = onNavigateToLevels)
        GenericButton(
            text = "Home",
            action = onNavigateToHome)

    }
}


