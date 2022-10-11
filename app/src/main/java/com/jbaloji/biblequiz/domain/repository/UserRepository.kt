package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.model.User

typealias UserResponse = Response<Boolean>

interface UserRepository {
    suspend fun addLocalUser () : UserResponse

    suspend fun getLocalUser() : String
}