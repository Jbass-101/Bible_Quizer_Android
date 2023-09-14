package com.jbaloji.biblequiz.presentation.home.contents

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
    sendNotification: (context: Context, title: String, message: String) -> Unit,
    showDialog : () -> Unit
){
    val context = LocalContext.current

    Surface(
        Modifier.fillMaxSize(),
        ) {
        Box(
            modifier = Modifier
                .safeContentPadding()
                .padding(12.dp, 0.dp),
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
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

                GenericButton(
                    text = stringResource(id = R.string.Start_Button_Text),
                    action = onNavigateToLobby,
                    textPadding = 12.dp
                )
                Spacer(modifier = Modifier.height(15.dp))
                GenericButton(
                    text = stringResource(id = R.string.Quit_Button_Text),
                    action = showDialog,
                    textPadding = 12.dp
//                action = {
//                    sendNotification(
//                        context,
//                        "Test Notification",
//                        "This is a cool message"
//                    )
//                }
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
        showDialog = { /*TODO*/ },
        sendNotification = {context, title, message ->  }
    )

}
