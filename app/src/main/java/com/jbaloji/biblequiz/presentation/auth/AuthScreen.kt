package com.jbaloji.biblequiz.presentation.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.domain.model.Response.Loading
import com.jbaloji.biblequiz.domain.model.Response.Success
import com.jbaloji.biblequiz.domain.model.Response.Failure
import com.jbaloji.biblequiz.presentation.auth.components.AuthScreenContents

@Composable
fun AuthScreen(
    onNavigateToHome: () -> Unit,
    vm: AuthViewModel = hiltViewModel()
){

    val context = LocalContext.current

    when(val signInAnonResponse = vm.signInAnonResponse){
        is Loading -> AuthScreenContents()
        is Success -> signInAnonResponse.apply {
            if(data){
                onNavigateToHome()
            }
        }
        is Failure -> signInAnonResponse.apply {
            LaunchedEffect(e){
                Utils.showMessage(
                    context,e?.message
                )
            }
        }
    }

}