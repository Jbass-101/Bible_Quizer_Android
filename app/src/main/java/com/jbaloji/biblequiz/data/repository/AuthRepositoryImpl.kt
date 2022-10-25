package com.jbaloji.biblequiz.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() = auth.currentUser

    override fun login(email: String, password: String) = callbackFlow {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { result ->
                val userResponse = if(result.isSuccessful){
                    Response.Success(auth.currentUser)
                } else {
                    Response.Failure(null)
                }
                trySend(userResponse)
            }
    }

    override fun signup(email: String, password: String) = callbackFlow {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { result ->
                val userResponse = if(result.isSuccessful){
                    Response.Success(auth.currentUser)
                } else {
                    Response.Failure(null)
                }
                trySend(userResponse)
            }
    }

    override fun logout() {
        auth.signOut()
    }

}