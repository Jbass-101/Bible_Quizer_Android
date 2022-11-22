package com.jbaloji.biblequiz

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import com.jbaloji.biblequiz.core.Constants
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.navigation.InitGraph
import com.jbaloji.biblequiz.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
 class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideSystemBars()

        setContent {
            InitGraph()
        }


    }


    private fun hideSystemBars() {
        //Make Full Screen
        WindowCompat.setDecorFitsSystemWindows(window,false)
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return
        // Configure the behavior of the hidden system bars
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }

//
//    fun writeFile(filename: String, contents: String){
//        try {
//            openFileOutput(filename,Context.MODE_PRIVATE).use {
//                it.write(contents.toByteArray())
//            }
//
//
//        }catch (e: Exception){
//
//
//
//            Utils.print(e)
//        }
//
//    }
//
//    fun readFile(filename: String) : String =
//        try {
//            openFileInput(filename).bufferedReader().readText()
//        }catch (e: Exception){
//            Utils.print(e)
//            writeFile(Constants.FILENAME,Constants.DEFAULT_USER)
//            Constants.DEFAULT_USER
//        }




}
