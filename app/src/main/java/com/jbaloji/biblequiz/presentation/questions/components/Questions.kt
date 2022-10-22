package com.jbaloji.biblequiz.presentation.questions.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.components.ProgressBar
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.Questions
import com.jbaloji.biblequiz.presentation.questions.QuestionsViewModel

@Composable
fun Questions (
    viewModel: QuestionsViewModel = hiltViewModel(),
    content: @Composable (currentIndex: Int,maxQuestions: Int,
                          currentQuestion: String, hint: String,
                           answer: String, options: List<String>) -> Unit
){
    when(val questionResponse = viewModel.questionResponse){
        is Response.Loading -> ProgressBar()
        is Response.Success -> content(
            currentIndex = viewModel.currentIndex,
            maxQuestions = questionResponse.data.size,
            currentQuestion = questionResponse.data[viewModel.currentIndex].question,
            hint = questionResponse.data[viewModel.currentIndex].hint,
            answer = questionResponse.data[viewModel.currentIndex].answer,
            options = viewModel.randomise(questionResponse.data[viewModel.currentIndex].options)
        ).also {

                viewModel.randomiseQuestions(questionResponse.data)

        }
        is Response.Failure -> Utils.print(questionResponse.e)
    }

}















/*
@Composable
fun Books(
    viewModel: BooksViewModel = hiltViewModel(),
    booksContent: @Composable (books: Books) -> Unit
) {
    when(val booksResponse = viewModel.booksResponse) {
        is Loading -> ProgressBar()
        is Success -> booksContent(booksResponse.data)
        is Failure -> print(booksResponse.e)
    }
}
*
* */