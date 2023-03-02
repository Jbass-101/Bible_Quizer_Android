package com.jbaloji.biblequiz.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun Splash(
    navController: NavController

    ){

    LaunchedEffect(key1 = true){
        delay(1500)
        navController.navigate(Screen.Home){
            popUpTo(0)
        }
    }
    
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        if (!isSystemInDarkTheme()){

            Image(painter = painterResource(id = R.drawable.splash_dark) , contentDescription = "Splash Logo" )

        }else {

            Image(painter = painterResource(id = R.drawable.splash_light) , contentDescription = "Splash Logo" )
        }

    }
    
}