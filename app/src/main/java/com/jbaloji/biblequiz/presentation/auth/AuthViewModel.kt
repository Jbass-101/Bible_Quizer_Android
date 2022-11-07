package com.jbaloji.biblequiz.presentation.auth


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.UserResponse
import com.jbaloji.biblequiz.domain.use_case.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel() {

    //User details
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var userName by mutableStateOf("")
    var isAnonymouse by mutableStateOf(authUseCases.currentUser.get()?.isAnonymous)

    //Loading
    var isLoading by mutableStateOf(false)

    //User Response
    var authResponse by mutableStateOf<UserResponse>(Response.Loading)
    var signUpResponse by mutableStateOf<UserResponse>(Response.Loading)

    //Log In or Sign Up
    var showLogin by mutableStateOf(true)

    fun login (email: String ,password: String ) = viewModelScope.launch {

        isLoading = true
        authResponse = Response.Loading

        if(email == "" || password == ""){
            authResponse = Response.Failure(Exception("Email or password cannot be empty"))

            delay(1000)
            isLoading = false



        } else {
            authUseCases.logIn(email,password).collect{response ->
                isLoading = false
                authResponse = response
            }

        }

    }

    fun signUp(email: String, password: String, userName: String) = viewModelScope.launch {

        isLoading = true
        authResponse = Response.Loading

        if(email == "" || password == "" || userName == ""){
            authResponse = Response.Failure(Exception("One or more options are empty"))

            delay(1000)
            isLoading = false



        } else {

            authUseCases.signUp(email,password,userName).collect{ response ->
                isLoading = false
                authResponse = response
            }

        }


    }

    fun linkWithAnonymouse (email: String, password: String, userName: String) = viewModelScope.launch {

        isLoading = true
        authResponse = Response.Loading

        if(email == "" || password == "" || userName == ""){
            authResponse = Response.Failure(Exception("One or more options are empty"))
            delay(1000)
            isLoading = false


        } else {

            authUseCases.linkWithAnonymous(email,password,userName).collect{ response ->
                isLoading = false
                authResponse = response
            }

        }



    }

    fun toggleShowLogin(){
        showLogin = !showLogin
    }


}