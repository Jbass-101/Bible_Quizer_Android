package com.jbaloji.biblequiz.data.repository

import com.google.firebase.firestore.CollectionReference
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.model.UserData
import com.jbaloji.biblequiz.domain.repository.UserDataRepository
import com.jbaloji.biblequiz.domain.repository.UserDataResponse
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userRef: CollectionReference
) : UserDataRepository {
    override fun writeUserData(
        user: String,
        gameType: String,
        docName: String
    ): Flow<UserDataResponse> = callbackFlow {
        val listener = userRef.document(user).collection(gameType).document(docName)
            .set( UserData())
            .addOnCompleteListener { result ->
                val userDataResponse = if(result.isSuccessful){
                    Response.Success(UserData())
                } else {
                    Utils.print(result.exception)
                    Response.Failure(result.exception)
                }
                trySend(userDataResponse)
            }
        awaitClose{
            listener.isComplete
        }
    }



    override fun getUserData(
        user: String,
        gameType: String,
        docName: String
    ) = callbackFlow {
        val snapshotListener = userRef.document(user).collection(gameType).document(docName)
            .addSnapshotListener{ snapshot, error ->
                val userDataResponse = if (snapshot != null){
                    val userData = snapshot.toObject(UserData::class.java)
                    Response.Success(userData!!)
            } else {
                Response.Failure(error)
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
                    Response.Success(true)
                } else {
                    Utils.print(result.exception)
                    Response.Failure(result.exception)
                }
                trySend(updateDataResponse)
            }
        awaitClose{
            listener.isComplete
        }
    }
}