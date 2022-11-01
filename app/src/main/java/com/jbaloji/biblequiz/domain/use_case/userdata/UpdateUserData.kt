package com.jbaloji.biblequiz.domain.use_case.userdata

import com.jbaloji.biblequiz.domain.repository.UserDataRepository

class UpdateUserData(private val repo: UserDataRepository) {

    operator fun invoke() = repo.updateUserdata()
}