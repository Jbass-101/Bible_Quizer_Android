package com.jbaloji.biblequiz.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.QuestionsResponse
import com.jbaloji.biblequiz.domain.repository.User
import com.jbaloji.biblequiz.domain.repository.UserResponse
import com.jbaloji.biblequiz.domain.use_case.auth.AuthUseCases
import com.jbaloji.biblequiz.domain.use_case.auth.CurrentUser
import com.jbaloji.biblequiz.domain.use_case.questions.QuestionsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.exitProcess

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel() {

    var userResponse by mutableStateOf<UserResponse>(Response.Loading)

    var currentUser by mutableStateOf<User>(null)

    init {
        if (authUseCases.currentUser.get() == null){
            loginAnonymously()
        } else {
            currentUser = authUseCases.currentUser.get()
        }
    }

    private fun loginAnonymously () = viewModelScope.launch {

        authUseCases.loginAnonymously().collect{ response ->
            userResponse = response
        }
    }


    fun logOut () = authUseCases.logOut()


    fun quitGame(){

        exitProcess(0)

    }


}
