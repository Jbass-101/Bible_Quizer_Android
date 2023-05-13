package com.jbaloji.biblequiz.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jbaloji.biblequiz.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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
    fun quitGame(){
        exitProcess(0)
    }

}
