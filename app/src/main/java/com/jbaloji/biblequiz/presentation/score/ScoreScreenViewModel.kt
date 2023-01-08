package com.jbaloji.biblequiz.presentation.score

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.core.Constants
import com.jbaloji.biblequiz.domain.use_case.auth.AuthUseCases
import com.jbaloji.biblequiz.domain.use_case.userdata.UserDataUseCases
import com.jbaloji.biblequiz.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val userDataUseCases: UserDataUseCases,
    private val authUseCases: AuthUseCases
) : ViewModel() {


    private val currentLevel: String = checkNotNull(savedStateHandle[Screen.Level_ID])
    private val savedScore: Int = checkNotNull(savedStateHandle[Screen.Saved_Score_ID])
    val currentScore: Int = checkNotNull(savedStateHandle[Screen.Current_Score_ID])

    init {
        Log.i(Constants.TAG,"Current level: $currentLevel - - - -" +
                "Saved Score: $savedScore - - - - " +
                "Current Score: $currentScore")

        if (currentScore > savedScore){
              updateData(currentScore)

        }
    }

    private fun updateData(newScore: Int) = viewModelScope.launch {
        authUseCases.currentUser.get()?.uid?.let {
            userDataUseCases.updateUserData(
                user = it,
                updateVal = newScore,
                fieldName = currentLevel
            ).collect()
        }
    }

}