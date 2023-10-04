package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.components.BibleVersePopUp
import com.jbaloji.biblequiz.components.MyAlertDialog
import com.jbaloji.biblequiz.domain.repository.Questions
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components.QuestionsScreenContents
import com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components.Questions

@Composable
fun QuestionsScreen(
    onNavigateToLevels : () -> Unit,
    navController: NavController,
    vm: QuestionsViewModel = hiltViewModel()
) {

        Questions() { questions: Questions ->

            vm.totalQuestions = questions.size
            QuestionsScreenContents(
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
                },
                getVerse = {verse -> vm.getVerse(verse)},
                toggleVerseDialog = {vm.toggleVerseDialog()}
            )
        }

    MyAlertDialog(
        showDialog = vm.showDialog,
        dialogText = "Quit Current Game",
        onCancel = { vm.toggleDialog() },
        onConfirm = { onNavigateToLevels() },
        onDismiss = { vm.toggleDialog() }
    )

    BibleVersePopUp(
        showDialog = vm.showVerseDialog,
        verseTitle = vm.verseTitle ,
        bibleVerse = vm.getVerseResponse,
    onDismiss = {vm.toggleVerseDialog()})


}



