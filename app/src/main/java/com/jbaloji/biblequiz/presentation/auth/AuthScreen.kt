package com.jbaloji.biblequiz.presentation.auth

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.components.ProgressBar
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.presentation.auth.components.LogIn
import com.jbaloji.biblequiz.presentation.auth.components.SignUp

@Composable
fun AuthScreen(
    onNavigateToHome: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel()
){
    val response = viewModel.authResponse


    when(viewModel.showLogin){
        true -> LogIn(
            viewModel = viewModel,
            onNavigateToHome = onNavigateToHome

        )
        false -> SignUp(
            viewModel = viewModel,
            onNavigateToHome = onNavigateToHome
        )
    }



    when(response){
        is Response.Loading ->
            if(viewModel.isLoading) ProgressBar()
        is Response.Success ->
            LaunchedEffect(Unit){
                onNavigateToHome()
            }
        is Response.Failure ->
            if(viewModel.isLoading)
            Toast.makeText(
                LocalContext.current, response.e?.message.toString(),
                Toast.LENGTH_LONG).show()
    }


}