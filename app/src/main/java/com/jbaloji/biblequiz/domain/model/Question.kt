package com.jbaloji.biblequiz.domain.model

data class Question (

    var question: String,
    var answer: String,
    var hint: String,
    var options: List<String>,
    var difficulty: Boolean

    )
