package com.jbaloji.biblequiz.presentation.features.firmFoundation.lesson


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.LessonResponse
import com.jbaloji.biblequiz.domain.repository.LessonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonVM @Inject constructor(
    private val lessonRepo: LessonsRepository,
) : ViewModel() {

    var lessonDataResponse by mutableStateOf<LessonResponse>(Response.Loading)

    init {
        initData()

    }

    private fun initData() = viewModelScope.launch {
        lessonDataResponse = Response.Loading
        lessonDataResponse = lessonRepo.getLessons("lesson_1")
    }


}