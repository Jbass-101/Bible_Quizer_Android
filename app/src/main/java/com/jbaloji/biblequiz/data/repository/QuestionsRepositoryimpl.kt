package com.jbaloji.biblequiz.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.jbaloji.biblequiz.domain.model.Question
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import java.util.Collections.shuffle
import javax.inject.Inject


class QuestionsRepositoryimpl @Inject constructor(
    private val collRef:  CollectionReference,
    private val docRef: DocumentReference
) : QuestionsRepository {

    override fun getQuestions() = callbackFlow {
        val snapshotListener = collRef.addSnapshotListener { snapshot, error ->
            val questionsResponse = if (snapshot != null){
                val questions = snapshot.toObjects(Question::class.java)
                shuffle(questions)
                Response.Success(questions )
            } else {
                Response.Failure(error)
            }
            trySend(questionsResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    override fun getQuestionsLevel(level: String) = callbackFlow {
        val collRefLevel = docRef.collection(level)
        val snapshotListener = collRefLevel.addSnapshotListener { snapshot, error ->
            val questionsResponse = if (snapshot != null){
                val questions = snapshot.toObjects(Question::class.java)
                shuffle(questions)
                Response.Success(questions )
            } else {
                Response.Failure(error)
            }
            trySend(questionsResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }


}