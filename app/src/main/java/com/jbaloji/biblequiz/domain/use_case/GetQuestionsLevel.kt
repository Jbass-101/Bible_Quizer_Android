package com.jbaloji.biblequiz.domain.use_case

import com.jbaloji.biblequiz.domain.repository.QuestionsRepository

class GetQuestionsLevel(
    private val repo: QuestionsRepository
) {
    operator fun invoke(level: String ) = repo.getQuestionsLevel(level)
}