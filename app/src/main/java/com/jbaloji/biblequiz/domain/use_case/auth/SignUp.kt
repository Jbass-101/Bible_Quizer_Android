package com.jbaloji.biblequiz.domain.use_case.auth

import com.jbaloji.biblequiz.domain.repository.AuthRepository

class SignUp (private val repo: AuthRepository) {

    operator fun invoke(
        email: String,
        password: String,
        userName: String

    ) = repo.signup(email,password,userName)
}