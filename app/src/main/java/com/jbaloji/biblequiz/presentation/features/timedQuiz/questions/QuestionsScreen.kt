package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.components.MyAlertDialog
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components.Questions
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components.QuestionsScreenContents

@Composable
fun QuestionsScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToScore: () -> Unit,
    onNavigateToDialog: () -> Unit,
    onNavigateToLevels : () -> Unit,
    navController: NavController,
    vm: QuestionsViewModel = hiltViewModel()
) {


    Questions { currentIndex, maxQuestions, currentQuestion, hint,
                answer, options ->

        vm.totalQuestions = maxQuestions

        QuestionsScreenContents(
            currentQuestion = currentQuestion,
            hint = hint,
            answer = answer,
            options = options,
            currentScore = vm.currentScore,
            currentQuestionNumber = currentIndex + 1,
            time = vm.currentTime,
            progress = vm.currentProgress,
            totalQuestions = maxQuestions,
            totalHints = vm.maxHints,
            isLastQuestion = vm.isLastQuestion,
            hasAnswered = vm.hasAnswered,
            toggleDialog = { vm.toggleDialog() },
            nextOrFinish = { vm.nextOrFinish() },
            onNavigateToScore = {
                navController.navigate(
                    "score/${vm.levelId}/${vm.savedScore}/${vm.currentScore}"
                )
            }
        )


        MyAlertDialog(
            showDialog = vm.showDialog,
            dialogText = "Quit Current Game",
            onCancel = { vm.toggleDialog() },
            onConfirm = { onNavigateToLevels() },
            onDismiss = { vm.toggleDialog() }
        )
    }

}



