package com.jbaloji.biblequiz.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jbaloji.biblequiz.presentation.home.HomeScreen
import com.jbaloji.biblequiz.presentation.questions.QuestionsScreen

@Composable
fun InitGraph  (
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home
) {
    NavHost(
        navController =navController,
        startDestination = startDestination,
    ){
        composable(
            route = Screen.Home
        ){
            HomeScreen(
                onNavigateToQuestions = { navController.navigate(Screen.Question)}

            )
        }
        composable(
            route = Screen.Question
        ){
            BackHandler(enabled = true) {
                //navController.navigate(Screen.QuestionQuit)

            }
            QuestionsScreen(
                onNavigateToHome = {navController.navigate(Screen.Home)}
            )
        }
    }

}