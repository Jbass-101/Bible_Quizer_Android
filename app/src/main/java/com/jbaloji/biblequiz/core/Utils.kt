package com.jbaloji.biblequiz.core


import android.util.Log
import com.jbaloji.biblequiz.core.Constants.TAG

class Utils  {
    companion object {

        fun print(e: Exception?) {
            Log.e(TAG, e?.message ?: e.toString())
        }



    }




}