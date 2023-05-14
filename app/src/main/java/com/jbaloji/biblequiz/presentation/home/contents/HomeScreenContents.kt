package com.jbaloji.biblequiz.presentation.home.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.components.GenericButton
import com.jbaloji.biblequiz.components.ShrinkableText

@Composable
fun HomeScreenContents(
    onNavigateToLobby : () -> Unit,
    showDialog : () -> Unit
){
    Surface(
        Modifier.fillMaxSize(),
        ) {
        Box(
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(0.dp,50.dp)
            ) {
                ShrinkableText(text = stringResource(id = R.string.app_name))
            }
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(15.dp))
                GenericButton(
                    text = stringResource(id = R.string.Start_Button_Text),
                    action = onNavigateToLobby
                )
                GenericButton(
                    text = stringResource(id = R.string.Quit_Button_Text),
                    action = showDialog
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

@Preview(name = "Home Screen")
@Composable
fun Home_Screen(){
    HomeScreenContents(
        onNavigateToLobby = { /*TODO*/ },
        showDialog = { /*TODO*/ }
    )

}
