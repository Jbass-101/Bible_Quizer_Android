package com.jbaloji.biblequiz.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jbaloji.biblequiz.components.ScreenWrapper
import com.jbaloji.biblequiz.presentation.auth.AuthScreen
import com.jbaloji.biblequiz.presentation.home.HomeScreen
import com.jbaloji.biblequiz.presentation.levels.LevelsScreen
import com.jbaloji.biblequiz.presentation.questions.QuestionsScreen
import com.jbaloji.biblequiz.presentation.score.ScoreScreen
import dagger.hilt.android.qualifiers.ApplicationContext

@Composable
fun InitGraph  (
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ){
        composable(
            route = Screen.Home
        ){
            BackHandler(enabled = true) {

            }
            ScreenWrapper {
                HomeScreen(
                    onNavigateToLevels = { navController.navigate(Screen.Levels)},
                    onNavigateToAuth = { navController.navigate(Screen.Auth)}
                )
            }
        }
        composable(
            route = Screen.Question,
            arguments = listOf(navArgument(Screen.Level_ID){type = NavType.StringType})
        ){
            BackHandler(enabled = true) {
                //navController.navigate(Screen.QuestionQuit)

            }
            QuestionsScreen(
                onNavigateToHome = {navController.navigate(Screen.Home)},
                onNavigateToScore = {navController.navigate(Screen.Score)}
            )
        }
        composable(
            route = Screen.Score
        ){
            BackHandler(enabled = true) {

            }
            ScoreScreen (
                onNavigateToHome = {navController.navigate(Screen.Home)}
            )
        }
        composable(
            route = Screen.Levels,
                    arguments = listOf(navArgument(Screen.User_ID){type = NavType.StringType})
        ){
            ScreenWrapper {
                LevelsScreen(
                    navController = navController
                )
            }
        }
        composable(
            route = Screen.Auth
        ){
            ScreenWrapper {

                AuthScreen(
                    onNavigateToHome = {navController.navigate(Screen.Home)}

                )
            }
        }
    }

}