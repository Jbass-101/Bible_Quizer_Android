package com.jbaloji.biblequiz.domain.use_case.userdata

import com.jbaloji.biblequiz.domain.repository.UserDataRepository

class GetUserData(private val repo:UserDataRepository) {

    operator fun invoke() = repo.getUserData()
}