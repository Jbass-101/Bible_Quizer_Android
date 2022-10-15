package com.jbaloji.biblequiz.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.QuestionsResponse
import com.jbaloji.biblequiz.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    var questionResponse by mutableStateOf<QuestionsResponse>(Response.Loading)

    init {
        getQuestions()
    }

    private fun getQuestions() = viewModelScope.launch {
        useCases.getQuestions().collect{ response ->
            questionResponse = response
        }
    }


}
