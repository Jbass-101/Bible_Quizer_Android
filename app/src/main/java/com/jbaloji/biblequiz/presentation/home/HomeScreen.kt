package com.jbaloji.biblequiz.presentation.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.components.MyAlertDialog
import com.jbaloji.biblequiz.presentation.home.contents.HomeScreenContents

@Composable
fun HomeScreen(
    onNavigateToLobby: () -> Unit,
    vm: HomeScreenViewModel = hiltViewModel()
)  {


//    navController.navigate(
//        Screen.LobbyUser + vm.currentUserResponse?.uid.toString()
//    )

    HomeScreenContents(
        onNavigateToLobby = onNavigateToLobby,
        showDialog = { vm.toggleDialog() },
        sendNotification = {context, title, message ->
            vm.sendNotification(context, title, message)
        }
    )

    MyAlertDialog(
        showDialog =vm.showDialog ,
        dialogText = "Quit Bible Quiz ?",
        onCancel = { vm.toggleDialog()},
        onConfirm = { vm.quitGame() },
        onDismiss = { vm.toggleDialog() }
    )



    
}


