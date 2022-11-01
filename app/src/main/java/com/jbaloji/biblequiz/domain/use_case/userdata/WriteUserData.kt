package com.jbaloji.biblequiz.domain.use_case.userdata

import com.jbaloji.biblequiz.domain.repository.UserDataRepository

class WriteUserData(private val repo : UserDataRepository) {

    operator fun invoke() = repo.writeUserData()
}