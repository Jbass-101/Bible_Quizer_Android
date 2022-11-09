package com.jbaloji.biblequiz.domain.use_case.userdata

import com.jbaloji.biblequiz.domain.repository.UserDataRepository

class UpdateUserData(private val repo: UserDataRepository) {

    operator fun invoke(
        userId: String = "userID",
        gameType: String = "Timed Quiz",
        docName: String ="Score",
        fieldName: String ="level_1",
        updateVal: Int = 0
    ) = repo.updateUserdata(
        userId,gameType,docName,fieldName,updateVal
    )
}