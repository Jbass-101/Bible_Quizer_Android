package com.jbaloji.biblequiz.core

import androidx.compose.ui.text.intl.Locale

object FirestoreModuleConstants {
    val Questions = if (Locale.current.language == "fr") {
        "Questions (Fr)"
    }else {
        "Questions"
    }
    val Foundation = if (Locale.current.language == "fr") {
        "Foundation (Fr)"
    }else {
        "Foundation"
    }
    const val Levels = "Levels"
    const val Users = "Users"
    const val Lessons = "Lessons"
}