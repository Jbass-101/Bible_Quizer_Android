package com.jbaloji.biblequiz.domain.model

data class Feature(
    var name: String = "",
    var onClick: () -> Unit,
    var icon: Int = 0

)
