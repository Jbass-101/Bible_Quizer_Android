package com.jbaloji.biblequiz.domain.model

import androidx.compose.ui.graphics.Outline
import java.util.Objects

data class Question (

    var question: String = "",
    var answer: String = "",
    var hint: String = "",
    var book: String = "",
    var options: List<String> = listOf()

    )
