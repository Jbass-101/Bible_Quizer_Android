package com.jbaloji.biblequiz.presentation.features.timedQuiz.score

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.core.Constants
import com.jbaloji.biblequiz.core.Constants.SCORE
import com.jbaloji.biblequiz.core.Constants.TIMED_QUIZ
import com.jbaloji.biblequiz.domain.repository.UserDataRepository
import com.jbaloji.biblequiz.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScoreScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val userRepo: UserDataRepository,
) : ViewModel() {


    private val currentLevel: String = checkNotNull(savedStateHandle[Screen.Level_ID])
    private val savedScore: Int = checkNotNull(savedStateHandle[Screen.Saved_Score_ID])
    val currentScore: Int = checkNotNull(savedStateHandle[Screen.Current_Score_ID])

    init {
        Log.i(
            Constants.TAG,"Current level: $currentLevel - - - -" +
                "Saved Score: $savedScore - - - - " +
                "Current Score: $currentScore")

        if (currentScore > savedScore){
              updateData(currentScore)
        }
    }

    private fun updateData(newScore: Int) = viewModelScope.launch {
        userRepo.updateScoreData(
            TIMED_QUIZ,SCORE,currentLevel,currentScore
        )
    }

}