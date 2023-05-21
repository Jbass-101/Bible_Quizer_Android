package com.jbaloji.biblequiz.presentation.home

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import com.jbaloji.biblequiz.notification.TestNotification
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.system.exitProcess

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val authRepo: AuthRepository
) : ViewModel() {

    var showDialog by mutableStateOf(false)

    fun toggleDialog(){
        showDialog = !showDialog
    }

    fun sendNotification(context: Context, title: String, message: String) = viewModelScope.launch {
        TestNotification(context,title,message).launchNotification(context)
    }
    fun quitGame(){
        exitProcess(0)
    }

}
