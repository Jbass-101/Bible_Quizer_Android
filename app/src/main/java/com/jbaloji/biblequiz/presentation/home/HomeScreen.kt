package com.jbaloji.biblequiz.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.presentation.home.components.GenericButton
import com.jbaloji.biblequiz.presentation.home.components.HomeScreenContents
import com.jbaloji.biblequiz.presentation.home.components.TitleText
import com.jbaloji.biblequiz.presentation.questions.QuestionsViewModel
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun HomeScreen(
    onNavigateToLevels: () -> Unit,

    viewModel: HomeScreenViewModel = hiltViewModel()

)  {
    BibleQuizTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background,
            content = {paddingValues ->

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
                                .padding(paddingValues)
                                .fillMaxSize()

                        ) {
                            HomeScreenContents (
                                contents = {
                                    TitleText()
                                    Spacer(modifier = Modifier.height(15.dp))
                                    GenericButton(
                                        text = "Start Quiz",
                                        action = onNavigateToLevels
                                    )
                                    GenericButton(
                                        text = "Quit",
                                        action = {viewModel.quitGame()}
                                    )


                                }
                            )
                            Row(
                                modifier = Modifier.weight(1f,false)
                            ) {
                                Text(text = "Demo-mode")
                            }


                        }

                    }
                }


            }

        )
    }
    
}


