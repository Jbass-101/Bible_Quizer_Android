package com.jbaloji.biblequiz.main

import android.Manifest.permission.POST_NOTIFICATIONS
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jbaloji.biblequiz.core.Constants
import com.jbaloji.biblequiz.navigation.InitGraph
import com.jbaloji.biblequiz.navigation.Screen
import com.jbaloji.biblequiz.notification.TestNotification
import com.jbaloji.biblequiz.theme.BibleQuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
 class MainActivity : ComponentActivity() {


    private lateinit var navController: NavHostController
    private val viewModel by viewModels<MainVM>()

    // Declare the launcher at the top of your Activity/Fragment:
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // FCM SDK (and your app) can post notifications.
            Log.i(Constants.TAG,"Notification permission Granted")
        } else {
            // TODO: Inform user that that your app will not show notifications.
            Log.i(Constants.TAG,"Notification permission denied")
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
//        actionBar?.hide()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissionLauncher.launch(POST_NOTIFICATIONS)
        }
        //Create Notification Channel
        TestNotification(applicationContext).createNotificationChannel()

        hideSystemBars()




        setContent {
            navController = rememberNavController()
            BibleQuizTheme() {
                InitGraph(
                    navController = navController
                )
            }
            AuthState()
        }

//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
//                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
//                return@OnCompleteListener
//            }
//
//            // Get new FCM registration token
//            val token = task.result
//
//            Log.d(TAG, token)
//        })
    }

    @Composable
    private fun AuthState() {
        val isUserSignedOut = viewModel.getAuthState().collectAsState().value
        if (isUserSignedOut) {
            navController.navigate(Screen.Auth)
        } else {
            navController.navigate(Screen.Home)
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











}
