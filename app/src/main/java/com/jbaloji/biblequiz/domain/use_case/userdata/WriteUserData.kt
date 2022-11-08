package com.jbaloji.biblequiz.domain.use_case.userdata

import com.jbaloji.biblequiz.domain.repository.UserDataRepository

class WriteUserData(private val repo : UserDataRepository) {

    operator fun invoke(
        userId: String = "userID",
        gameType: String = "Timed Quiz",
        level: String ="Score"
    ) = repo.writeUserData(userId,gameType, level)
}