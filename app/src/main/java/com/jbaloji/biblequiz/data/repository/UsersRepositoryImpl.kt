package com.jbaloji.biblequiz.data.repository

import com.google.firebase.firestore.CollectionReference
import com.jbaloji.biblequiz.di.FireStoreModule
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.UserRepository
import com.jbaloji.biblequiz.domain.repository.UserResponse

class UsersRepositoryImpl(
    @FireStoreModule.UsersRef private val collRef: CollectionReference
) : UserRepository {
    override suspend fun addLocalUser(): UserResponse {

        return try {


            Response.Success(true)
        }catch (e: Exception){
            Response.Failure(e)
        }
    }

    override suspend fun getLocalUser(): String {
        return ""
    }

}