package com.jbaloji.biblequiz.domain.questions.repository

import com.jbaloji.biblequiz.domain.questions.model.Question
import com.jbaloji.biblequiz.domain.Response
import kotlinx.coroutines.flow.Flow

typealias Questions = List<Question>
typealias BooksRespose = Response<Questions>

interface QuestionsRepository {
    fun getQuestions() : Flow<BooksRespose>
}