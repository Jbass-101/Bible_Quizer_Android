package com.jbaloji.biblequiz.presentation.levels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.jbaloji.biblequiz.navigation.Screen.Level_1
import com.jbaloji.biblequiz.navigation.Screen.Level_2
import com.jbaloji.biblequiz.navigation.Screen.Level_3
import com.jbaloji.biblequiz.navigation.Screen.Level_4
import com.jbaloji.biblequiz.navigation.Screen.Level_5
import com.jbaloji.biblequiz.presentation.home.components.GenericButton

@Composable
fun LevelsScreen(
    navController: NavController
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        GenericButton(
            text = "Level 1",
            action = {navController.navigate(Level_1)}
        )
        GenericButton(
            text = "Level 2",
            action = {navController.navigate(Level_2)},
            enabled = false
        )
        GenericButton(
            text = "Level 3",
            action = {navController.navigate(Level_3)},
            enabled = false
        )
        GenericButton(
            text = "Level 4",
            action = {navController.navigate(Level_4)},
            enabled = false
        )
        GenericButton(
            text = "Level 5",
            action = {navController.navigate(Level_5)},
            enabled = false
        )
    }


}