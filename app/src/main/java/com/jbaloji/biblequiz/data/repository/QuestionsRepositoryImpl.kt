package com.jbaloji.biblequiz.data.repository

import com.google.firebase.firestore.DocumentReference
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.core.Utils.Companion.myCatch
import com.jbaloji.biblequiz.domain.model.Question
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.QuestionsRepository
import kotlinx.coroutines.tasks.await
import java.util.Collections.shuffle
import javax.inject.Inject

class QuestionsRepositoryImpl @Inject constructor(
    private val docRef: DocumentReference
) : QuestionsRepository {


    override suspend fun getQuestionsLevel(level: String) = try {
        Utils.myLog("Getting Questions for $level.............")
        val question = docRef.collection(level).get().await().toObjects(Question::class.java)

        question.forEach{
            shuffle(it.options)
        }
        shuffle(question)
        Response.Success(question)

    }catch (e: Exception){
        myCatch(e)
        Response.Failure(e)
    }

}
