package com.jbaloji.biblequiz.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.components.ProfileCard
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.presentation.home.components.GenericButton
import com.jbaloji.biblequiz.presentation.home.components.HomeScreenContents
import com.jbaloji.biblequiz.presentation.home.components.TitleText
import com.jbaloji.biblequiz.presentation.questions.QuestionsViewModel
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun HomeScreen(
    onNavigateToLobby: () -> Unit,
    onNavigateToAuth: () -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()

)  {
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
                TitleText()
                Spacer(modifier = Modifier.height(15.dp))
                if(viewModel.currentUserResponse != null){
                    ProfileCard()
                } else {
                    Text(text = "No User Found")
                }
                Spacer(modifier = Modifier.height(15.dp))
                GenericButton(
                    text = stringResource(id = R.string.Start_Button_Text),
                    action = onNavigateToLobby
                )
                GenericButton(
                    text = stringResource(id = R.string.Quit_Button_Text),
                    action = {viewModel.quitGame()}
                )
                Spacer(modifier = Modifier.height(15.dp))
                if(viewModel.currentUserResponse != null){
                GenericButton(
                    text = "Log Out",
                    action = { viewModel.logOut() }
                )}else {
                    GenericButton(
                        text = "Log In",
                        action = onNavigateToAuth
                    )
                }

            }

        }
    }
    
}

