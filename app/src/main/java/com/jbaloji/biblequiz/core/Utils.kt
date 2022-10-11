package com.jbaloji.biblequiz.core

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import com.jbaloji.biblequiz.MainActivity
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.FileReader
import java.io.FileWriter

class Utils {
    companion object {

        fun print(e: Exception?) {
            Log.e("TEST", e?.message ?: e.toString())
        }

        fun randomString (len: Int) : String {
            val chars = ('0'..'9') + ('a'..'z') + ('A'..'Z')

            return(1..len)
                .map {
                    chars.random()
                }
                .toString()
        }



    }

}