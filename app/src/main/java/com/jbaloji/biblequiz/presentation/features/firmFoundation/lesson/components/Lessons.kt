package com.jbaloji.biblequiz.presentation.features.firmFoundation.lesson.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.Lessons
import com.jbaloji.biblequiz.presentation.features.firmFoundation.lesson.LessonVM

@Composable
fun Lessons(
    vm: LessonVM = hiltViewModel(),
    content: @Composable (lessons: Lessons) -> Unit
){
    when(val lessonsResponse = vm.lessonDataResponse){
        is Response.Loading -> Utils.print(Exception("Loading.........."))
        is Response.Success -> lessonsResponse.apply {
            content(data)
        }
        is Response.Failure -> Utils.print(lessonsResponse.e)
    }

}