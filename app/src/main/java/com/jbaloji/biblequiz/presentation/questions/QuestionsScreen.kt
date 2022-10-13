package com.jbaloji.biblequiz.presentation.questions

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.presentation.questions.components.*
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun QuestionsScreen(
    viewModel: QuestionsViewModel = hiltViewModel()
) {
    BibleQuizTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background,
            content = {paddingValues ->

                Box(modifier = Modifier.padding(paddingValues))
                Column(
                    modifier = Modifier.padding(20.dp,30.dp)

                ) {
                    
                    Questions { currentIndex, maxQuestions, currentQuestion, hint,
                                explanation,answer,options ->

                        viewModel.totalQuestions = maxQuestions


                        QuestionNumberText(
                            currentQuestion = currentIndex + 1,
                            totalQuestions = maxQuestions,
                            maxHints = viewModel.maxHints,
                            totalScore = viewModel.totalScore
                        )
                        CountDown()
                        QuestionText(currentQuestion)
                        HintAndExplanationText(
                            hintText = hint,
                            explanation = explanation,
                            )
                        AnswerButtonContainer(
                            options = options,
                            answer = answer,
                        )
                        MiscButtonContainer(
                            hasAnswered = viewModel.hasAnswered,
                            nextQuestion = { viewModel.nextQuestion()
                            }, quitGame = {
                                viewModel.quitGame()
                            })


                    }

                }


            }

        )
    }

}

