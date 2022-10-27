package com.jbaloji.biblequiz.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.presentation.home.components.GenericButton
import com.jbaloji.biblequiz.presentation.home.components.HomeScreenContents
import com.jbaloji.biblequiz.presentation.home.components.TitleText
import com.jbaloji.biblequiz.presentation.questions.QuestionsViewModel
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun HomeScreen(
    onNavigateToLevels: () -> Unit,
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
                Text(
                    text ="Current user: ${viewModel.currentUser?.displayName}"
                )
                Spacer(modifier = Modifier.height(15.dp))
                GenericButton(
                    text = "Start Quiz",
                    action = onNavigateToLevels
                )
                GenericButton(
                    text = "Quit",
                    action = {viewModel.quitGame()}
                )

                Text(text = "Demo-mode")
                if (viewModel.currentUser?.isAnonymous == true ||
                    viewModel.currentUser == null){

                    GenericButton(
                        text = "Log In" ,
                        action = onNavigateToAuth
                    )
                }else {
                    GenericButton(
                        text ="Log Out" ,
                        action = { viewModel.logOut() }
                    )
                }





            }

        }
    }

    
}


