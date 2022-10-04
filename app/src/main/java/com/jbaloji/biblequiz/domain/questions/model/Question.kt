package com.jbaloji.biblequiz.domain.questions.model

data class Question (

    var question: String,
    var answer: String,
    var hint: String,
    var options: List<String>,
    var difficulty: Boolean

    )
