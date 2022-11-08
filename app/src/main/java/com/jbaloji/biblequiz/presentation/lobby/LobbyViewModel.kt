package com.jbaloji.biblequiz.presentation.lobby

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.core.Constants
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.UserDataResponse
import com.jbaloji.biblequiz.domain.repository.UserResponse
import com.jbaloji.biblequiz.domain.use_case.auth.AuthUseCases
import com.jbaloji.biblequiz.domain.use_case.userdata.UserDataUseCases
import com.jbaloji.biblequiz.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LobbyViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val authUseCases: AuthUseCases,
    private val userDataUseCases: UserDataUseCases
) : ViewModel() {

    private val userId: String = checkNotNull(savedStateHandle[Screen.User_ID])
    var userResponse by mutableStateOf<UserResponse>(Response.Loading)
    var userDataResponse by mutableStateOf<UserDataResponse>(Response.Loading)

    init {
        Log.i(Constants.TAG,"Current user UID: $userId")
        if(userId == "null"){
            loginAnonymously()
        } else {
            /*@TODO*/
           getCurrentUser()
        }
    }

    private fun loginAnonymously () = viewModelScope.launch {
        authUseCases.loginAnonymously().collect{ response ->
            userResponse = response

            when(response){
                is Response.Success -> {
                    userDataUseCases.writeUserData(
                        userId = response.data?.uid!!
                    ).collect{res ->
                        userDataResponse = res
                    }
                }
                is Response.Failure ->
                    userResponse = Response.Failure(response.e)
                else -> {}
            }


        }



    }

    private fun getCurrentUser () = viewModelScope.launch {
        authUseCases.getCurrentUser().collect{ response ->
            userResponse = Response.Success(response)
        }
    }
}