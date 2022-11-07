package com.jbaloji.biblequiz.presentation.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.presentation.auth.AuthViewModel
import com.jbaloji.biblequiz.presentation.home.components.GenericButton
import com.jbaloji.biblequiz.presentation.theme.Overlay

@Composable
fun SignUp(
    viewModel: AuthViewModel,
    onNavigateToHome: () -> Unit,

){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "User Sign Up")
//        Row() {
//            IconButton(
//                modifier = Modifier
//                    .background(color = Overlay),
//                onClick = { /*TODO*/ }) {
//                Icon(
//                    painter = painterResource(id = R.drawable.male_profile_icon),
//                    contentDescription = "Icon" )
//            }
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(
//                    painter = painterResource(id = R.drawable.female_profile_icon),
//                    contentDescription = "Icon" )
//            }
//
//        }
        GenericTextField(
            label = "Name",
            placeholder = "John Doe",
            icon = 0,
            value = viewModel.userName ,
            keyboardType = KeyboardType.Text
        ) { onChange ->
            viewModel.userName = onChange
        }
        GenericTextField(
            label = "Email",
            placeholder = "JohnDoe@mail.com",
            icon = 1,
            value = viewModel.email ,
            keyboardType = KeyboardType.Email
        ) { onChange ->
            viewModel.email = onChange
        }
        GenericTextField(
            label = "Password",
            placeholder = "Password" ,
            icon = 2,
            value = viewModel.password ,
            keyboardType = KeyboardType.Password ,
            imeAction = ImeAction.Done,
        ) { onChange ->
            viewModel.password = onChange
        }

        GenericButton(
            text = "Sign Up" ,
            action = {
                if (viewModel.isAnonymouse == true){
                    viewModel.linkWithAnonymouse(
                        userName = viewModel.userName,
                        email = viewModel.email,
                        password = viewModel.password)

                }else {
                    viewModel.signUp(
                        userName = viewModel.userName,
                        email = viewModel.email,
                        password = viewModel.password)

                }
            }
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Have an Account ?"
            )
            Spacer(modifier = Modifier.width(12.dp))
            OutlinedButton(
                onClick = { viewModel.toggleShowLogin() }
            ) {
                Text(text = "Log In")
                
            }
            
        }
        GenericButton(
            text = "Home",
            action = onNavigateToHome
        )


    }
}