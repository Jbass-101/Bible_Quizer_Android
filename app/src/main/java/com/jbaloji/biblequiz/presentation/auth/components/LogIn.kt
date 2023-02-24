package com.jbaloji.biblequiz.presentation.auth.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.presentation.auth.AuthViewModel
import com.jbaloji.biblequiz.presentation.home.components.GenericButton

@Composable
fun LogIn(
    viewModel: AuthViewModel,
    onNavigateToHome: () -> Unit,
){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .blur(
                0.dp
            )
    ) {
        Text(text = "User Log In")

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
            text = "Log In" ,
            action = { viewModel.login(
                email = viewModel.email,
                password = viewModel.password
            )}
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't Have an Account ?"
            )
            Spacer(modifier = Modifier.width(12.dp))
            OutlinedButton(
                onClick = { viewModel.toggleShowLogin()  }
            ) {
                Text(text = "Sign Up")

            }
        }
        Spacer(modifier = Modifier.width(12.dp))

        GenericButton(
            text = "home",
            action = onNavigateToHome
        )


    }

}