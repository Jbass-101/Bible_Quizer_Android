package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.Question
import com.jbaloji.biblequiz.domain.model.Response

typealias Questions = List<Question>
typealias QuestionsResponse = Response<Questions>

interface QuestionsRepository {
    suspend fun getQuestionsLevel(level: String) : QuestionsResponse

}