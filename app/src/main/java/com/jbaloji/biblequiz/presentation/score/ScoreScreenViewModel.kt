package com.jbaloji.biblequiz.presentation.score

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.core.Constants
import com.jbaloji.biblequiz.domain.use_case.userdata.UserDataUseCases
import com.jbaloji.biblequiz.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val userDataUseCases: UserDataUseCases
) : ViewModel() {


    private val currentLevel: String = checkNotNull(savedStateHandle[Screen.Level_ID])
    private val currentScore: Int = checkNotNull(savedStateHandle[Screen.Current_Score_ID])
    private val savedScore: Int = checkNotNull(savedStateHandle[Screen.Saved_Score_ID])

    init {
        Log.i(Constants.TAG,"Current level: $currentLevel - - - -" +
                "Saved Score: $savedScore - - - - " +
                "Current Score: $currentScore")
      //  updateData()
    }

    private fun updateData() = viewModelScope.launch {
        userDataUseCases.updateUserData(
            updateVal = currentScore
        ).collect()
    }

}