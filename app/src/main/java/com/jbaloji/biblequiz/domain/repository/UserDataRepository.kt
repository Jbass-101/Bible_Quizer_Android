package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.model.UserData
import kotlinx.coroutines.flow.Flow

typealias UserDataResponse = Response<UserData>

interface UserDataRepository {

    fun writeUserData(
        userId: String,
        gameType: String,
        level: String
    ): Flow<UserDataResponse>

    fun getUserData(): Flow<UserDataResponse>

    fun updateUserdata(): Flow<UserDataResponse>


}