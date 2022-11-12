package com.jbaloji.biblequiz.domain.use_case.userdata

import com.jbaloji.biblequiz.domain.repository.UserDataRepository

class GetUserData(private val repo:UserDataRepository) {

    operator fun invoke(
        gameType: String = "Timed Quiz",
        docName: String ="Score",
    ) = repo.getUserData(gameType,docName)
}