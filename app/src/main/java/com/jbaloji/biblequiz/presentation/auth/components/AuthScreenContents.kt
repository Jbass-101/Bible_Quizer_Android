package com.jbaloji.biblequiz.presentation.auth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.jbaloji.biblequiz.R

@Composable
fun AuthScreenContents(){
    Surface(
        modifier = Modifier.fillMaxSize()) {
        Box(
            contentAlignment = Alignment.Center,
        ) {

            if (isSystemInDarkTheme()){

                Image(painter = painterResource(id = R.drawable.splash_light) , contentDescription = "Splash Logo" )

            }else {

                Image(painter = painterResource(id = R.drawable.splash_dark) , contentDescription = "Splash Logo" )
            }

        }

    }

}