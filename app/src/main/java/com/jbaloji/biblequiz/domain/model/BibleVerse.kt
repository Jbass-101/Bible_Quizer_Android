package com.jbaloji.biblequiz.domain.model

data class BibleVerse(
    var verse: Array<String> = emptyArray<String>(),
    var startVerse: Int = 1
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BibleVerse

        if (!verse.contentEquals(other.verse)) return false

        return true
    }

    override fun hashCode(): Int {
        return verse.contentHashCode()
    }
}

