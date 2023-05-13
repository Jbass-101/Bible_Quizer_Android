package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.components.ProgressBar
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.QuestionsViewModel

@Composable
fun Questions_ (
    vm: QuestionsViewModel = hiltViewModel()
){
    when(val questionResponse = vm.questionResponse){
        is Response.Loading -> ProgressBar()
        is Response.Success -> questionResponse.apply {
            vm.totalQuestions = data.size
            val options = vm.randomise(data[vm.currentIndex].options)

            QuestionsScreenContents(
                q = data[vm.currentIndex],
                options = options,
                randomise = {
                    vm.randomise(it)
                },
                currentScore = vm.currentScore ,
                currentQuestionNumber = vm.currentIndex + 1 ,
                totalQuestions = data.size ,
                totalHints = vm.maxHints ,
                showHint = vm.isHint ,
                isLastQuestion = vm.isLastQuestion,
                hasAnswered = vm.hasAnswered,
                toggleHint = { vm.showHint()},
                toggleDialog = { vm.toggleDialog()},
                onNext = { vm.nextOrFinish() },
                answerQuestion = {vm.answerQuestion(it)
                },
                onComplete = {}
            )

        }
        is Response.Failure -> Utils.print(questionResponse.e)
    }

}












