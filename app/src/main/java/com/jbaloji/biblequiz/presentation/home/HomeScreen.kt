package com.jbaloji.biblequiz.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.components.ProfileCard
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
                ProfileCard()
                Spacer(modifier = Modifier.height(15.dp))
                GenericButton(
                    text = "Start Quiz",
                    action = onNavigateToLevels
                )
                GenericButton(
                    text = "Quit",
                    action = {viewModel.quitGame()}
                )
                Spacer(modifier = Modifier.height(15.dp))
                GenericButton(
                    text = "Log In",
                    action = onNavigateToAuth
                )

            }

        }
    }
    
}


