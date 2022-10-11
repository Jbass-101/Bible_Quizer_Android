package com.jbaloji.biblequiz.presentation.splash

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.data.repository.LocalUserRepositoryImpl
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.use_case.UseCases
import com.jbaloji.biblequiz.room.entities.LocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import io.grpc.okhttp.internal.Util
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val repo: LocalUserRepositoryImpl
) : ViewModel() {

    var userAvailable by mutableStateOf(false)

     var user: LocalUser? = null

    init {
        getUser()
    }



    private fun getUser() {

        viewModelScope.launch {
            try {
                var check  = repo.getLocalUser()
                if (check == null){

                    var localUser = LocalUser(
                        uid = Utils.randomString(10),
                        firstName ="Not Signed IN",
                        lastName = ""
                    )

                    repo.insertUser(localUser)

                    user = localUser
                } else {
                    user = check
                }

            }catch (e: Exception){
                Utils.print(e)
            }

            }
        }


    }




