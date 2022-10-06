package com.jbaloji.biblequiz.presentation.questions

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response.Loading
import com.jbaloji.biblequiz.domain.repository.BooksRespose
import com.jbaloji.biblequiz.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val useCases : UseCases
) : ViewModel() {
    var booksRespose by mutableStateOf<BooksRespose>(Loading)
    private set

     fun getBooks() = viewModelScope.launch {

        Log.i("Test","Inside the gerBooks()")

        useCases.getQuestions().collect{ response ->
            booksRespose = response
           Log.i("Test",response.toString())

        }
    }
}