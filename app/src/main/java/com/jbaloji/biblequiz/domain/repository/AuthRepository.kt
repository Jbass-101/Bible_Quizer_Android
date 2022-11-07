package com.jbaloji.biblequiz.domain.repository

import com.google.firebase.auth.FirebaseUser
import com.jbaloji.biblequiz.domain.model.Response
import kotlinx.coroutines.flow.Flow

typealias User = FirebaseUser?
typealias UserResponse = Response<User>

interface AuthRepository {

    val currentUser: User

    fun getCurrentUser() : Flow<User>

    fun login(email: String, password: String): Flow<UserResponse>

    fun loginAnonymously(): Flow<UserResponse>

    fun linkWithAnonymous(email: String,password: String,userName: String): Flow<UserResponse>

    fun signup(email: String, password: String, userName: String): Flow<UserResponse>

    fun logout()

}