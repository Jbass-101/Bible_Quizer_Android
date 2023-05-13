package com.jbaloji.biblequiz.presentation.auth


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response.Loading
import com.jbaloji.biblequiz.domain.model.Response.Success
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import com.jbaloji.biblequiz.domain.repository.AuthResponseBoolean
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {

    var signInAnonResponse by mutableStateOf<AuthResponseBoolean>(Success(false))
        private set

    init {
        signInAnonymously()
    }

    private fun signInAnonymously() = viewModelScope.launch {
        signInAnonResponse = Loading
        signInAnonResponse = repo.signInAnonymously()
    }

}