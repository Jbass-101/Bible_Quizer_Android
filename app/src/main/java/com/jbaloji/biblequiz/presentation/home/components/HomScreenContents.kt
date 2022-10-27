package com.jbaloji.biblequiz.presentation.home.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.components.ProgressBar
import com.jbaloji.biblequiz.core.Utils
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.presentation.home.HomeScreenViewModel
import io.grpc.okhttp.internal.Util

@Composable
fun HomeScreenContents(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    contents: @Composable () -> Unit
) {
//    when(val response = viewModel.questionResponse){
//        is Response.Loading -> contents()//ProgressBar()
//        is Response.Success -> contents(
//        )
//        is Response.Failure -> Utils.print(response.e)
//    }
}