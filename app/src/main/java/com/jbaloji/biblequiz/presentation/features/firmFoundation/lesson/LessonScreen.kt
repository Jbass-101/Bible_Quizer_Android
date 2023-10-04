package com.jbaloji.biblequiz.presentation.features.firmFoundation.lesson

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.components.BibleVersePopUp
import com.jbaloji.biblequiz.core.Constants.TAG
import com.jbaloji.biblequiz.domain.repository.Lessons
import com.jbaloji.biblequiz.presentation.features.firmFoundation.lesson.components.LessonScreenContents
import com.jbaloji.biblequiz.presentation.features.firmFoundation.lesson.components.Lessons

@Composable
fun LessonScreen(
    vm: LessonVM = hiltViewModel()
){
    Lessons() {lessons: Lessons ->

        LessonScreenContents(
            lessons = lessons,
            getVerse = {verse -> vm.getVerse(verse)},
            toggleVerseDialog = { vm.toggleVerseDialog() }
        )
    }

    BibleVersePopUp(
        showDialog = vm.showVerseDialog,
        verseTitle = vm.verseTitle ,
        bibleVerse = vm.getVerseResponse,
        onDismiss = {vm.toggleVerseDialog()})

}