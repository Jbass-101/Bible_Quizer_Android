package com.jbaloji.biblequiz.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.navigation.Screen
import com.jbaloji.biblequiz.presentation.home.components.GenericButton
import com.jbaloji.biblequiz.presentation.home.components.TitleText

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = hiltViewModel()

)  {

    val context = LocalContext.current
    Box(){
//                    Image(
//                        painter = painterResource(id = R.drawable.background ),
//                        contentDescription = "background",
//                        contentScale = ContentScale.FillHeight,
//                        modifier = Modifier.fillMaxSize()
//                    )
        Box() {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()

            ) {
//                Image(painter = painterResource(id = R.drawable.logo_light), contentDescription = "Hello" )
                TitleText()
//                Spacer(modifier = Modifier.height(15.dp))
//                if(viewModel.currentUserResponse != null){
//                    ProfileCard(viewModel.currentUserResponse!!)
//                    Text(text = viewModel.currentUserResponse?.uid.toString())
//                } else {
//                    Text(text = "No User Found")
//                }
                Spacer(modifier = Modifier.height(15.dp))
                GenericButton(
                    text = stringResource(id = R.string.Start_Button_Text),
                    action = {navController.navigate(
                        Screen.LobbyUser + viewModel.currentUserResponse?.uid.toString()
                    )}
                )
                GenericButton(
                    text = stringResource(id = R.string.Quit_Button_Text),
                    action = {viewModel.quitGame()}
                )
                Spacer(modifier = Modifier.height(15.dp))
//                GenericButton(
//                    text = "Launch Notification" ,
//                    action = { TestNotification(context).launchNotification() })
//                if(viewModel.currentUserResponse?.isAnonymous == false){
//                GenericButton(
//                    text = "Log Out",
//                    action = { viewModel.logOut() }
//                )}else {
//                    GenericButton(
//                        text = "Log In",
//                        action = onNavigateToAuth
//                    )
//                }

            }

        }
    }
    
}


