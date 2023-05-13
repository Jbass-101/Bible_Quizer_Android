package com.jbaloji.biblequiz.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.core.Utils.Companion.myCatch
import com.jbaloji.biblequiz.core.Utils.Companion.myLog
import com.jbaloji.biblequiz.domain.model.Response.Failure
import com.jbaloji.biblequiz.domain.model.Response.Success
import com.jbaloji.biblequiz.domain.model.TimedQuizScore
import com.jbaloji.biblequiz.domain.repository.UserDataRepository
import com.jbaloji.biblequiz.domain.repository.UserDataResponseBoolean
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataRepositoryImpl @Inject constructor(
    private val userRef: CollectionReference,
    authRef : FirebaseAuth
) : UserDataRepository {

    private val currentUser = authRef.currentUser?.uid!!
    override suspend fun initUserData(gameType: String,docName: String, data: TimedQuizScore) = try {
        myLog("Initializing user data for $gameType ........")
        userRef.document(currentUser).collection(gameType).document(docName).set(data).await()
        Success(true)
    }catch (e: Exception){
        myCatch(e)
        Failure(e)
    }

    override suspend fun getScoreData(gameType: String, docName: String) = try {
        myLog("Getting Score Data for $gameType ........")
        Success(
            userRef.document(currentUser).collection(gameType).document(docName).get().await().toObject(TimedQuizScore::class.java)!!
        )
    }catch (e: Exception){
        myCatch(e)
        Failure(e)
    }

    override suspend fun updateScoreData(
        gameType: String,
        docName: String,
        fieldName: String,
        updateVal: Int
    ) = try {
        myLog("Updating $gameType's $fieldName to $updateVal ")
        userRef.document(currentUser).collection(gameType).document(docName)
            .update(fieldName,updateVal).await()
        Success(true)

    }catch (e:Exception){
        myCatch(e)
        Failure(e)

    }


    override fun getUserData(
        user: String,
        gameType: String,
        docName: String
    ) = callbackFlow {
        val snapshotListener = userRef.document(user).collection(gameType).document(docName)
            .addSnapshotListener{ snapshot, error ->
                val userDataResponse = if (snapshot != null){
                    val userData = snapshot.toObject(TimedQuizScore::class.java)
                    Success(userData!!)
            } else {
                Failure(error)
                }
                trySend(userDataResponse)
            }
        awaitClose{
            snapshotListener.remove()
        }
    }

    override fun updateUserdata(
        user: String,
        gameType: String,
        docName: String,
        fieldName: String,
        updateVal: Int
    ) = callbackFlow {
        val listener = userRef.document(user).collection(gameType).document(docName)
            .update(fieldName,updateVal)
            .addOnCompleteListener { result ->
                val updateDataResponse =if (result.isSuccessful){
                    Success(true)
                } else {
                    Utils.print(result.exception)
                    Failure(result.exception)
                }
                trySend(updateDataResponse)
            }
        awaitClose{
            listener.isComplete
        }
    }
}