package com.jbaloji.biblequiz.presentation.features.timedQuiz.levels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.core.Constants.SCORE
import com.jbaloji.biblequiz.core.Constants.TIMED_QUIZ
import com.jbaloji.biblequiz.domain.model.Response.Loading
import com.jbaloji.biblequiz.domain.model.Response.Success
import com.jbaloji.biblequiz.domain.model.TimedQuizScore
import com.jbaloji.biblequiz.domain.repository.UserDataRepository
import com.jbaloji.biblequiz.domain.repository.UserDataResponse
import com.jbaloji.biblequiz.domain.repository.UserDataResponseBoolean
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelsViewModel @Inject constructor(
    private val userRepo: UserDataRepository,
    ) : ViewModel() {

    var userDataResponse by mutableStateOf<UserDataResponse>(Loading)
    var scoreDataResponse by mutableStateOf<UserDataResponse>(((Loading)))
    var initTimedQuizResponse by mutableStateOf<UserDataResponseBoolean>(Success(false))



        init {
            getScoreData()
        }

    fun initScoreData() = viewModelScope.launch {
        initTimedQuizResponse = Loading
        initTimedQuizResponse = userRepo.initUserData(TIMED_QUIZ, SCORE,TimedQuizScore())
    }
    private fun getScoreData() = viewModelScope.launch {
        scoreDataResponse = Loading
        scoreDataResponse = userRepo.getScoreData(TIMED_QUIZ, SCORE)
    }




}