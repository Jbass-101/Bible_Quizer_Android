package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.Questions
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.QuestionsViewModel

@Composable
fun Questions(
    viewModel: QuestionsViewModel = hiltViewModel(),
    content: @Composable (questions: Questions) -> Unit
){
    when(val questionResponse = viewModel.questionResponse){
        is Response.Loading -> QuestionShimmer()
        is Response.Success -> questionResponse.apply {
            content(data)
        }
        is Response.Failure -> Utils.print(questionResponse.e)
    }

}












