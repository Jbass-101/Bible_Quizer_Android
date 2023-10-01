package com.jbaloji.biblequiz.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.core.Utils.Companion.myCatch
import com.jbaloji.biblequiz.domain.model.Lesson
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.LessonResponse
import com.jbaloji.biblequiz.domain.repository.Lessons
import com.jbaloji.biblequiz.domain.repository.LessonsRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class LessonRepositoryImpl @Inject constructor(
    private val docRef : DocumentReference
) : LessonsRepository {
    override suspend fun getLessons(lesson: String) =try {
        Utils.myLog("Getting Lessons for $lesson.............")
        val data = docRef.collection(lesson).get().await().toObjects(Lesson::class.java)

        Response.Success(data)

    }catch (e: Exception){
        myCatch(e)
        Response.Failure(e)
    }

}