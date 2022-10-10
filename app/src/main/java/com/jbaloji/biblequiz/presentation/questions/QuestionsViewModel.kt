package com.jbaloji.biblequiz.presentation.questions


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response.Loading
import com.jbaloji.biblequiz.domain.repository.QuestionsResponse
import com.jbaloji.biblequiz.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Collections.shuffle
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val useCases : UseCases
) : ViewModel() {
    var questionResponse by mutableStateOf<QuestionsResponse>(Loading)
    var options by mutableStateOf(listOf<String>())

    var currentIndex by mutableStateOf(0)
    var totalQuestions by mutableStateOf(0)
    var maxHints by mutableStateOf(5)
    var isHint by mutableStateOf(false)
    var hasAnswered by mutableStateOf(false)
    var totalScore by mutableStateOf(0)

    private var firstQuestionFlag by mutableStateOf(true)



    init {
        getQuestions()


    }

     private fun getQuestions() = viewModelScope.launch {

        useCases.getQuestions().collect{ response ->
            questionResponse = response

        }
    }

    fun answerQuestion (option:String, answer: String ) : Boolean {
        return if(option == answer){
            totalScore++
            true
        } else {
            false
        }

    }

    fun showHint(){
        if (!isHint && maxHints > 0){
            maxHints--
            isHint = true

        }
    }


    fun nextQuestion(){
        if (currentIndex < totalQuestions - 1){
            isHint = false;
            currentIndex++
        }
    }

    fun quitGame() {




    }

    fun randomise(options: List<String>): List<String>{
        firstQuestionFlag = false

        var myArr = listOf(0,1,2,3)
        var myList = mutableListOf<String>()

        shuffle(myArr)

        for (i in myArr){
            myList.add(options[i])
        }

        return myList

    }

    fun getFirstGameFlag() = firstQuestionFlag

}