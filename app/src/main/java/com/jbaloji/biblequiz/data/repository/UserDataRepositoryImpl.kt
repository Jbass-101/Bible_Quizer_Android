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
        userId: String,
        gameType: String,
        docName: String
    ) = callbackFlow {
        val listener = userRef.document(userId).collection(gameType).document(docName)
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



    override fun getUserData(): Flow<UserDataResponse> {
        TODO("Not yet implemented")
    }

    override fun updateUserdata(
        userId: String,
        gameType: String,
        docName: String,
        fieldName: String,
        updateVal: Int
    ) = callbackFlow {
        val listener = userRef.document(userId).collection(gameType).document(docName)
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