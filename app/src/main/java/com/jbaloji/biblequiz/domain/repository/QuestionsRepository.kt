package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.Question
import com.jbaloji.biblequiz.domain.model.Response
import kotlinx.coroutines.flow.Flow

typealias Questions = List<Question>
typealias QuestionsResponse = Response<Questions>

interface QuestionsRepository {
    fun getQuestions() : Flow<QuestionsResponse>

}