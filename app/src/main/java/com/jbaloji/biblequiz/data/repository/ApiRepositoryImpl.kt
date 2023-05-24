package com.jbaloji.biblequiz.data.repository

import com.jbaloji.biblequiz.core.Utils.Companion.myLog
import com.jbaloji.biblequiz.domain.model.BibleVerse
import com.jbaloji.biblequiz.domain.repository.ApiRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepositoryImpl @Inject constructor(
    private val api : ApiRepository,
)  {
    suspend fun getVerse(verse: String): BibleVerse{

        myLog("Getting bible verse : $verse")

        val result = api.getVerse(verse)

        return if (result.toString().isNotEmpty()){
            myLog("Backend result ${result.verse}")
            result
        }else {
            BibleVerse()
        }
    }
}