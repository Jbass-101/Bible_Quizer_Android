package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.components.ProgressBar
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.QuestionsViewModel

@Composable
fun Questions (
    viewModel: QuestionsViewModel = hiltViewModel(),
    content: @Composable (currentIndex: Int,maxQuestions: Int,
                          currentQuestion: String, hint: String,
                           answer: String, options: List<String>) -> Unit
){
    when(val questionResponse = viewModel.questionResponse){
        is Response.Loading -> ProgressBar()
        is Response.Success ->
            content(
                currentIndex = viewModel.currentIndex,
                maxQuestions = questionResponse.data.size,
                currentQuestion = questionResponse.data[viewModel.currentIndex].question,
                hint = questionResponse.data[viewModel.currentIndex].hint,
                answer = questionResponse.data[viewModel.currentIndex].answer,
                options = viewModel.randomise(questionResponse.data[viewModel.currentIndex].options)
            )
        is Response.Failure -> Utils.print(questionResponse.e)
    }

}












