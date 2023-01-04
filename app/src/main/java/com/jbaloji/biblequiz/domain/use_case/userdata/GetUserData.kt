package com.jbaloji.biblequiz.domain.use_case.userdata

import com.jbaloji.biblequiz.core.Constants.DOC_NAME
import com.jbaloji.biblequiz.core.Constants.GAME_TYPE
import com.jbaloji.biblequiz.domain.repository.UserDataRepository

class GetUserData(private val repo:UserDataRepository) {

    operator fun invoke(
        gameType: String = GAME_TYPE,
        docName: String = DOC_NAME,
    ) = repo.getUserData(gameType,docName)
}