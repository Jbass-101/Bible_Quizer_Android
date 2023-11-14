package com.jbaloji.biblequiz.domain.model

data class TimedQuizScore (
    var level_1: Int = 0,
    var level_2: Int = 0,
    var level_3: Int = 0,
    var level_4: Int = 0,
    var level_5: Int = 0,
    var level_6: Int = 0,
    var level_7: Int = 0,
    var level_8: Int = 0,
    var level_9: Int = 0,
    var level_10: Int = 0,
    var level_11: Int = 0,
    var level_12: Int = 0,
    var level_13: Int = 0,
    var level_14: Int = 0,
    var level_15: Int = 0,
    var level_16: Int = 0,
    var level_17: Int = 0,
    var level_18: Int = 0,
    var level_19: Int = 0,
    var level_20: Int = 0,
    var score: List<Int> = listOf(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
)