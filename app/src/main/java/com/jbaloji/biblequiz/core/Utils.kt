package com.jbaloji.biblequiz.core

import android.util.Log

class Utils {
    companion object {
        fun print(e: Exception?) {
            Log.e("TEST", e?.message ?: e.toString())
        }
    }
}