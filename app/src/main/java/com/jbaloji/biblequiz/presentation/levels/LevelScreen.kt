package com.jbaloji.biblequiz.presentation.levels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigator
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.navigation.Screen.Level_1
import com.jbaloji.biblequiz.navigation.Screen.Level_2
import com.jbaloji.biblequiz.navigation.Screen.Level_3
import com.jbaloji.biblequiz.navigation.Screen.Level_4
import com.jbaloji.biblequiz.navigation.Screen.Level_5
import com.jbaloji.biblequiz.presentation.home.components.GenericButton

@Composable
fun LevelsScreen(
    navController: NavController,
    viewModel: LevelsViewModel = hiltViewModel()
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        GenericButton(
            text = "Level 1",
            action = {navController.navigate(
                Level_1 +"/"+ viewModel.score1
            )}
        )
        GenericButton(
            text = "Level 2",
            action = {navController.navigate(
                Level_2 +"/"+ viewModel.score2
            )},
            enabled = viewModel.score1 > 8
        )
        GenericButton(
            text = "Level 3",
            action = {navController.navigate(
                Level_3 +"/"+ viewModel.score3
            )},
            enabled = viewModel.score2 > 8
        )
        GenericButton(
            text = "Level 4",
            action = {navController.navigate(
                Level_4 +"/"+ viewModel.score4
            )},
            enabled = viewModel.score3 > 8
        )
        GenericButton(
            text = "Level 5",
            action = {navController.navigate(
                Level_5 +"/"+ viewModel.score4
            )},
            enabled = viewModel.score4 > 8
        )
    }


    when(val response = viewModel.userDataResponse){
        is Response.Success -> {
            viewModel.score1 = response.data.level_1
            viewModel.score2 = response.data.level_2
            viewModel.score3 = response.data.level_3
            viewModel.score4 = response.data.level_4
        }
        else -> {}
    }





}