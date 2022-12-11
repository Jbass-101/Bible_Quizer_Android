package com.jbaloji.biblequiz.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jbaloji.biblequiz.components.PauseDialogScreen
import com.jbaloji.biblequiz.components.ScreenWrapper
import com.jbaloji.biblequiz.presentation.auth.AuthScreen
import com.jbaloji.biblequiz.presentation.home.HomeScreen
import com.jbaloji.biblequiz.presentation.levels.LevelsScreen
import com.jbaloji.biblequiz.presentation.lobby.LobbyScreen
import com.jbaloji.biblequiz.presentation.questions.QuestionsScreen
import com.jbaloji.biblequiz.presentation.score.ScoreScreen

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
                    navController = navController,
                    onNavigateToLobby = { navController.navigate(Screen.Lobby)},
                    onNavigateToAuth = { navController.navigate(Screen.Auth)}
                )
            }
        }
        composable(
            route = Screen.PauseDialog
        ){
            ScreenWrapper {
            PauseDialogScreen(

                onBack = { navController.navigateUp() } ,
                onNavigateToLobby = {navController.navigate(Screen.Lobby){
                    popUpTo(Screen.Lobby)
                } },
                onNavigateToLevels = {navController.navigate(Screen.Levels){
                    popUpTo(Screen.Levels)
                } }
            )
        }

        }
        composable(
            route = Screen.Question,
            arguments = listOf(
                navArgument(Screen.Level_ID){type = NavType.StringType},
                navArgument(Screen.Saved_Score_ID){type = NavType.IntType}
            )
        ){
            BackHandler(enabled = true) {
                //navController.navigate(Screen.QuestionQuit)

            }
            ScreenWrapper {

                QuestionsScreen(
                    onNavigateToHome = {navController.navigate(Screen.Home)},
                    onNavigateToScore = {navController.navigate(Screen.Score)},
                    onNavigateToDialog = {navController.navigate(Screen.PauseDialog)},
                    navController = navController
                )
            }
        }
        composable(
            route = Screen.Score,
            arguments = listOf(
                navArgument(Screen.Level_ID){type = NavType.StringType},
                navArgument(Screen.Saved_Score_ID){type = NavType.IntType},
                navArgument(Screen.Current_Score_ID){type = NavType.IntType}
            )
        ){
            BackHandler(enabled = true) {

            }
            ScreenWrapper {
                ScoreScreen (
                    onNavigateToHome = {navController.navigate(Screen.Home)},
                    onNavigateToLevels = {navController.navigate(Screen.Levels)}
                )
            }
        }
        composable(
            route = Screen.Levels
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
            BackHandler(enabled = true) {}
            ScreenWrapper {
                AuthScreen(
                    onNavigateToHome = {navController.navigate(Screen.Home)}
                )
            }
        }
        composable(
            route = Screen.Lobby,
            arguments = listOf(navArgument(Screen.User_ID){type = NavType.StringType})
        ){
            BackHandler(enabled = true) {

            }
            ScreenWrapper {
                LobbyScreen (
                    onNavigateToLevels = { navController.navigate(Screen.Levels)},
                    onNavigateToHome = {navController.navigate(Screen.Home)}
                )
            }
        }
    }

}