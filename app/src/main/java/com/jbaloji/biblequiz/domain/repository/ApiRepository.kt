package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.BibleVerse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiRepository {

    @GET("/api/bible_en")
    suspend fun getVerse(@Query(value = "verse") verse : String) : BibleVerse
}