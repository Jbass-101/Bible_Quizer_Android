package com.jbaloji.biblequiz.presentation.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.core.Constants
import com.jbaloji.biblequiz.domain.repository.User
import com.jbaloji.biblequiz.domain.use_case.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.exitProcess

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel() {

//    var userResponse by mutableStateOf<UserResponse>(Response.Loading)
    var currentUserResponse by mutableStateOf<User>(null)

    var currentUser by mutableStateOf<User>(null)

    init {
        getCurrentUser()
    }
//
//    private fun loginAnonymously () = viewModelScope.launch {
//
//        authUseCases.loginAnonymously().collect{ response ->
//            userResponse = response
//        }
//    }

    private fun getCurrentUser () = viewModelScope.launch {
        authUseCases.getCurrentUser().collect{ response ->
            currentUserResponse = response
            Log.i(Constants.TAG,"Home Screen user : ${response?.uid.toString()}")
        }
    }


    fun logOut () = authUseCases.logOut()


    fun quitGame(){

        exitProcess(0)

    }


}
