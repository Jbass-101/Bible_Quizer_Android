package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response.Loading
import com.jbaloji.biblequiz.domain.repository.QuestionsResponse
import com.jbaloji.biblequiz.domain.use_case.questions.QuestionsUseCases
import com.jbaloji.biblequiz.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.Collections.shuffle
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCases : QuestionsUseCases,
) : ViewModel() {

    val levelId: String = checkNotNull(savedStateHandle[Screen.Level_ID])
    val savedScore: Int = checkNotNull(savedStateHandle[Screen.Saved_Score_ID])






    //Question Feature
    var questionResponse by mutableStateOf<QuestionsResponse>(Loading)
    var currentIndex by mutableStateOf(0)
    var totalQuestions by mutableStateOf(0)

    //Answer Feature
    var hasAnswered by mutableStateOf(false)
    var currentScore by mutableStateOf(0)
    var isLastQuestion by mutableStateOf(false)

    //Hint Feature
    var maxHints by mutableStateOf(5)
    var isHint by mutableStateOf(false)

    //Counter Feature
    var currentTime by mutableStateOf(0)
    var currentProgress by mutableStateOf(1f)
    private var totalTime by mutableStateOf(60)

    //Quit menu
    var showQuitMenu by mutableStateOf(false)
    var showDialog by mutableStateOf(false)




    init {
        getQuestionsLevel(levelId)
        startCountDown()
    }

    private fun getQuestionsLevel(level: String) = viewModelScope.launch {
        useCases.getQuestionLevel(level).collect{ response ->
            questionResponse = response
        }
    }

     private fun startCountDown() = viewModelScope.launch {
         currentTime = totalTime

         while (isActive){
             if(currentTime == 0){
                 answerQuestion(false)
             }

             if (hasAnswered){
                 cancel()
             }



             delay(1000L)
             currentTime--
             currentProgress = currentTime.toFloat() / totalTime.toFloat()

         }

    }


     fun answerQuestion (correctAnswer: Boolean) {
        hasAnswered = true
        if (correctAnswer) currentScore++
    }

    fun showHint(){
        if (!isHint && maxHints > 0 && !hasAnswered){
            maxHints--
            isHint = true
        }
    }


    fun nextOrFinish(){
        hasAnswered = false
        isHint = false

        if (currentIndex < totalQuestions - 1){
            isHint = false
            currentIndex++
            currentProgress = 1f
            startCountDown()

            if(currentIndex == totalQuestions - 1){
                isLastQuestion = true
            }
        }
    }

    fun toggleDialog() {
        showDialog = !showDialog
    }

    fun randomise(options: List<String>): List<String>{

        val myArr = listOf(0,1,2,3)
        val myList = mutableListOf<String>()

        shuffle(myArr)

        for (i in myArr){
            myList.add(options[i])
        }

        return myList

    }




}