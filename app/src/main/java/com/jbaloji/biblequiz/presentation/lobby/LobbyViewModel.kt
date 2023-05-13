package com.jbaloji.biblequiz.presentation.lobby

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import com.jbaloji.biblequiz.domain.repository.UserDataRepository
import com.jbaloji.biblequiz.domain.repository.UserDataResponse
import com.jbaloji.biblequiz.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LobbyViewModel @Inject constructor(
//    savedStateHandle: SavedStateHandle,
    private val authUseCases: AuthRepository,
    private val userDataUseCases: UserDataRepository
) : ViewModel() {

//    private val userId: String = checkNotNull(savedStateHandle[Screen.User_ID])
    var userDataResponse by mutableStateOf<UserDataResponse>(Response.Loading)


}