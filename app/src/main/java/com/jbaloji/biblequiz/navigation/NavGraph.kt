package com.jbaloji.biblequiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jbaloji.biblequiz.presentation.home.HomeScreen
import com.jbaloji.biblequiz.presentation.questions.QuestionsScreen

@Composable
fun InitGraph(
    navController: NavHostController
) {
    NavHost(
        navController =navController,
        startDestination = Screens.Home.route,
    ){
        composable(
            route = Screens.Home.route
        ){
            HomeScreen(navController)
        }
        composable(
            route = Screens.Questions.route
        ){
            QuestionsScreen()
        }
    }

}