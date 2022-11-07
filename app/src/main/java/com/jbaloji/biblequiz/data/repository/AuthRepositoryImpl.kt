package com.jbaloji.biblequiz.data.repository


import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.jbaloji.biblequiz.core.Utils.Companion.print
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {
    override val currentUser: FirebaseUser?
        get() = auth.currentUser

    override fun getCurrentUser() = callbackFlow {
        auth.addAuthStateListener { result ->
            val userResponse = result.currentUser

            trySend(userResponse)
        }
        awaitClose{

        }
    }

    override fun login(email: String, password: String) = callbackFlow {
        val listener = auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { result ->
                val userResponse = if(result.isSuccessful){
                    Response.Success(auth.currentUser)
                } else {
                    Response.Failure(result.exception)
                }
                trySend(userResponse)
            }
        awaitClose{
            listener.isComplete
        }
    }

    override fun loginAnonymously() = callbackFlow {
        val listener = auth.signInAnonymously()
            .addOnCompleteListener { result ->
                val userResponse = if(result.isSuccessful){

                    print(auth.currentUser)
                    Response.Success(auth.currentUser)
                } else {

                    print(result.exception)


                    Response.Failure(null)

                }
                trySend(userResponse)
            }
        awaitClose {
            listener.isComplete
        }
    }

    override fun linkWithAnonymous(
        email: String,
        password: String,
        userName: String
    ) = callbackFlow {
        val listener = auth.currentUser!!.linkWithCredential(
            EmailAuthProvider.getCredential(email, password))
            .addOnCompleteListener { result ->
                val userResponse = if(result.isSuccessful){

                auth.currentUser?.updateProfile(userProfileChangeRequest {
                    displayName = userName
                })

                print(auth.currentUser)
                Response.Success(auth.currentUser)

            } else {
                print(result.exception)
                Response.Failure(result.exception)
            }
                trySend(userResponse)
            }
        awaitClose { listener.isComplete }
    }

    override fun signup(email: String, password: String, userName: String) = callbackFlow {
        val listener = auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { result ->
                val userResponse = if(result.isSuccessful){

                    auth.currentUser?.updateProfile(userProfileChangeRequest {
                        displayName = userName
                    })

                    print(auth.currentUser)
                    Response.Success(auth.currentUser)
                } else {

                    print(result.exception)
                    Response.Failure(result.exception)
                }
                trySend(userResponse)
            }
        awaitClose {
            listener.isComplete
        }
    }

    override fun logout() = auth.signOut()

}