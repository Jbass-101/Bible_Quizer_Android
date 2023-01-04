package com.jbaloji.biblequiz.presentation.levels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.UserDataResponse
import com.jbaloji.biblequiz.domain.use_case.userdata.UserDataUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelsViewModel @Inject constructor(
    private val userDataUseCases: UserDataUseCases
    ) : ViewModel() {

     var userDataResponse by mutableStateOf<UserDataResponse>(Response.Loading)

    var score1 by mutableStateOf(0)
    var score2 by mutableStateOf(0)
    var score3 by mutableStateOf(0)
    var score4 by mutableStateOf(0)
    var score5 by mutableStateOf(0)
    var score6 by mutableStateOf(0)
    var score7 by mutableStateOf(0)
    var score8 by mutableStateOf(0)
    var score9 by mutableStateOf(0)
    var score10 by mutableStateOf(0)
    var score11 by mutableStateOf(0)
    var score12 by mutableStateOf(0)
    var score13 by mutableStateOf(0)
    var score14 by mutableStateOf(0)
    var score15 by mutableStateOf(0)
    var score16 by mutableStateOf(0)
    var score17 by mutableStateOf(0)
    var score18 by mutableStateOf(0)
    var score19 by mutableStateOf(0)
    var score20 by mutableStateOf(0)

        init {
            getUserData()


        }

    private fun getUserData() = viewModelScope.launch {
        userDataUseCases.getUserData().collect{response ->
            userDataResponse = response

        }




    }


}