package com.jbaloji.biblequiz.presentation.features.firmFoundation.lesson


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.data.repository.ApiRepositoryImpl
import com.jbaloji.biblequiz.domain.model.BibleVerse
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.repository.LessonResponse
import com.jbaloji.biblequiz.domain.repository.LessonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonVM @Inject constructor(
    private val lessonRepo: LessonsRepository,
    private val apiRepo : ApiRepositoryImpl
) : ViewModel() {

    var lessonDataResponse by mutableStateOf<LessonResponse>(Response.Loading)


    //Verse
    var getVerseResponse by mutableStateOf(BibleVerse())
    var showVerseDialog by mutableStateOf(false)
    var verseTitle by mutableStateOf("")

    init {
        initData()

    }

    private fun initData() = viewModelScope.launch {
        lessonDataResponse = Response.Loading
        lessonDataResponse = lessonRepo.getLessons("lesson_1")
    }

    fun getVerse(verse : String) = viewModelScope.launch {
        verseTitle = verse
        getVerseResponse = BibleVerse()
        getVerseResponse = apiRepo.getVerse(verse)
    }
    fun toggleVerseDialog(){
        showVerseDialog = !showVerseDialog
    }


}