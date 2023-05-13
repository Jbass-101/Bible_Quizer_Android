package com.jbaloji.biblequiz.data.repository


import com.google.firebase.auth.FirebaseAuth
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.core.Utils.Companion.myCatch
import com.jbaloji.biblequiz.core.Utils.Companion.myLog
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {

    override fun getAuthState(viewModelScope: CoroutineScope) = callbackFlow {
        myLog("Getting Auth State.............")
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), auth.currentUser == null)

    override suspend fun signInAnonymously() = try {
        myLog("Signing In Anonymously......")
        auth.signInAnonymously().await()
        Response.Success(true)
    } catch (e: Exception) {
        myCatch(e)
        Response.Failure(e)
    }

    override fun signOut() = auth.signOut()


}