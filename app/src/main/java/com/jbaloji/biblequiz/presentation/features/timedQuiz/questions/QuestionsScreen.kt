package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.components.MyAlertDialog
import com.jbaloji.biblequiz.domain.repository.Questions
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components.QuestionsScreenContents_
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components.Questions_

@Composable
fun QuestionsScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToScore: () -> Unit,
    onNavigateToDialog: () -> Unit,
    onNavigateToLevels : () -> Unit,
    navController: NavController,
    vm: QuestionsViewModel = hiltViewModel()
) {

        Questions_() {questions: Questions ->

            vm.totalQuestions = questions.size
            QuestionsScreenContents_(
                q = questions[vm.currentIndex],
                score = vm.currentScore,
                questionNumber = vm.currentIndex + 1,
                totalQuestions = questions.size,
                totalHints = vm.maxHints,
                progress = vm.currentProgress,
                time =vm.currentTime ,
                hint = vm.isHint,
                hasAnswered = vm.hasAnswered,
                isLastQuestion = vm.isLastQuestion ,
                answerQuestion = {vm.answerQuestion(it)} ,
                toggleDialog = { vm.toggleDialog() },
                onShowHint = { vm.showHint() },
                onNext = { vm.nextOrFinish() },
                onNavigateToScore = {
                    navController.navigate(
                        "score/${vm.levelId}/${vm.savedScore}/${vm.currentScore}"
                    )
                }
            )
        }

    MyAlertDialog(
        showDialog = vm.showDialog,
        dialogText = "Quit Current Game",
        onCancel = { vm.toggleDialog() },
        onConfirm = { onNavigateToLevels() },
        onDismiss = { vm.toggleDialog() }
    )


}



