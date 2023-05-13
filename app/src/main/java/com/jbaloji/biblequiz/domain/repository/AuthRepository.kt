package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

typealias AuthStateResponse = StateFlow<Boolean>
typealias AuthResponseBoolean = Response<Boolean>

interface AuthRepository {
    fun getAuthState(viewModelScope: CoroutineScope): AuthStateResponse

    suspend fun signInAnonymously(): AuthResponseBoolean

    fun signOut()

}