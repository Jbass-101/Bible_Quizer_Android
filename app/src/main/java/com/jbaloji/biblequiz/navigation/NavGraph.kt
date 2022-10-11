package com.jbaloji.biblequiz.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jbaloji.biblequiz.presentation.splash.SplashScreen

@Composable
fun initNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController =navController,
        startDestination = Screens.Splash.route,
    ){
        composable(
            route = Screens.Splash.route
        ){
            SplashScreen()
        }
    }

}