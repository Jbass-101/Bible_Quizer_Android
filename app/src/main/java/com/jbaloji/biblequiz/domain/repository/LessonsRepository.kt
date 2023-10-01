package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.Lesson
import com.jbaloji.biblequiz.domain.model.Response

typealias Lessons = List<Lesson>
typealias LessonResponse = Response<Lessons>

interface LessonsRepository {
    suspend fun getLessons(lesson: String) : LessonResponse
}