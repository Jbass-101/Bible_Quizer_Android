package com.jbaloji.biblequiz.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.components.GenericButton
import com.jbaloji.biblequiz.components.TitleText
import com.jbaloji.biblequiz.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()

)  {

    val context = LocalContext.current
    Surface(

        Modifier.fillMaxSize(),

    ) {
        Box(
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center)
            ) {
                TitleText()

                Spacer(modifier = Modifier.height(15.dp))
                GenericButton(
                    text = stringResource(id = R.string.Start_Button_Text),
                    action = {
                        navController.navigate(
                            Screen.LobbyUser + viewModel.currentUserResponse?.uid.toString()
                        )
                    }
                )
                GenericButton(
                    text = stringResource(id = R.string.Quit_Button_Text),
                    action = { viewModel.quitGame() }
                )

            }


            Box(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.BottomCenter)
            ) {
                if (isSystemInDarkTheme()) {

                    Image(
                        painter = painterResource(id = R.drawable.splash_light),
                        contentDescription = "Splash Logo"
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.splash_dark),
                        contentDescription = "Splash Logo"
                    )
                }

            }

        }
    }
    
}


