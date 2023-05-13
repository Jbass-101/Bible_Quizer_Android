package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.model.TimedQuizScore
import kotlinx.coroutines.flow.Flow

typealias UserDataResponse = Response<TimedQuizScore>
typealias UserDataResponseBoolean = Response<Boolean>

interface UserDataRepository {

    suspend fun initUserData(
        gameType: String,
        docName : String,
        data : TimedQuizScore

    ) : UserDataResponseBoolean

    suspend fun getScoreData(
        gameType: String,
        docName: String
    ) : UserDataResponse

    suspend fun updateScoreData(
        gameType: String,
        docName: String,
        fieldName: String,
        updateVal: Int
    ) : UserDataResponseBoolean

    fun getUserData(
        user: String,
        gameType: String,
        docName: String
    ): Flow<UserDataResponse>

    fun updateUserdata(
        user: String,
        gameType: String,
        docName: String,
        fieldName: String,
        updateVal: Int
    ): Flow<Response<Boolean>>


}