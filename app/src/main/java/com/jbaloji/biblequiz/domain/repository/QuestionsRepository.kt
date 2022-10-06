package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.Question
import com.jbaloji.biblequiz.domain.model.Response
import kotlinx.coroutines.flow.Flow

typealias Questions = List<Question>
typealias BooksRespose = Response<Questions>

interface QuestionsRepository {
    fun getQuestions() : Flow<BooksRespose>
}