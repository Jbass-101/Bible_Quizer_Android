package com.jbaloji.biblequiz.presentation.questions


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response.Loading
import com.jbaloji.biblequiz.domain.repository.QuestionsResponse
import com.jbaloji.biblequiz.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.util.Collections.shuffle
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val useCases : UseCases,
) : ViewModel() {


    //Question Feature
    var questionResponse by mutableStateOf<QuestionsResponse>(Loading)
    var currentIndex by mutableStateOf(0)
    var totalQuestions by mutableStateOf(0)

    //Answer Feature
    var hasAnswered by mutableStateOf(false)
    var totalScore by mutableStateOf(0)

    //Hint Feature
    var maxHints by mutableStateOf(5)
    var isHint by mutableStateOf(false)

    //Counter Feature
    var currentTime by mutableStateOf(0)
    var currentProgress by mutableStateOf(1f)
    private var totalTime by mutableStateOf(60)

    //Quit menu
    var showQuitMenu by mutableStateOf(false)







    init {
        getQuestions()
        startCountDown()
    }

     private fun getQuestions() = viewModelScope.launch {

        useCases.getQuestions().collect{ response ->
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
        if (correctAnswer) totalScore++
    }

    fun showHint(){
        if (!isHint && maxHints > 0 && !hasAnswered){
            maxHints--
            isHint = true
        }

    }


    fun nextQuestion(){
        hasAnswered = false
        isHint = false
        if (currentIndex < totalQuestions - 1){
            startCountDown()
            isHint = false;
            currentIndex++
        }
    }

    fun toggleQuitMenu() {
        showQuitMenu = !showQuitMenu

    }

    fun randomise(options: List<String>): List<String>{

        var myArr = listOf(0,1,2,3)
        var myList = mutableListOf<String>()

        shuffle(myArr)

        for (i in myArr){
            myList.add(options[i])
        }

        return myList

    }


}