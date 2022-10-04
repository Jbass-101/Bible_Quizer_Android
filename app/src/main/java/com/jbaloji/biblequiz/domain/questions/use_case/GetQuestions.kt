package com.jbaloji.biblequiz.domain.questions.use_case

import com.jbaloji.biblequiz.domain.questions.repository.QuestionsRepository

class GetQuestions(private val repo : QuestionsRepository) {

    operator fun invoke() = repo.getQuestions()

}