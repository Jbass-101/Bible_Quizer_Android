package com.jbaloji.biblequiz.domain.use_case.userdata

data class UserDataUseCases (
    val writeUserData: WriteUserData,
    val getUserData: GetUserData,
    val updateUserData: UpdateUserData

        )