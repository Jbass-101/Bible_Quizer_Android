package com.jbaloji.biblequiz.core


import android.content.Context
import android.util.Log
import android.widget.Toast
import com.jbaloji.biblequiz.core.Constants.TAG
import com.jbaloji.biblequiz.domain.model.Response

class Utils  {
    companion object {
        fun print(e: Exception?) {
            Log.e(TAG, e?.message ?: e.toString())
        }
        fun showMessage(
            context: Context,
            message: String?
        ) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()



        private const val TAG = "RepoTAG"
        private const val LOGGING = false

        fun myLog(logString : String){
            if(LOGGING){
                Log.i(TAG,logString)
            }
        }

        fun myCatch(e: Exception){
            if (LOGGING) {
                Log.e(TAG,e.message.toString())
            }
        }



    }




}