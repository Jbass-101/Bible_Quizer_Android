package com.jbaloji.biblequiz.domain.use_case.userdata

import com.jbaloji.biblequiz.core.Constants.DOC_NAME
import com.jbaloji.biblequiz.core.Constants.FIELD_NAME
import com.jbaloji.biblequiz.core.Constants.GAME_TYPE
import com.jbaloji.biblequiz.core.Constants.UPDATE_VAL
import com.jbaloji.biblequiz.domain.repository.UserDataRepository

class UpdateUserData(private val repo: UserDataRepository) {

    operator fun invoke(
        gameType: String = GAME_TYPE,
        docName: String = DOC_NAME,
        fieldName: String = FIELD_NAME,
        updateVal: Int = UPDATE_VAL
    ) = repo.updateUserdata(
        gameType,docName,fieldName,updateVal
    )
}