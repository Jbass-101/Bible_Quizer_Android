package com.jbaloji.biblequiz.domain.use_case.auth

data class AuthUseCases(
    val currentUser: CurrentUser,
    val logIn: LogIn,
    val signUp: SignUp,
    val logOut: LogOut,
    val loginAnonymously: LoginAnonymously
)
