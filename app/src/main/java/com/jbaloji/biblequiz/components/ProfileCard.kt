package com.jbaloji.biblequiz.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.google.firebase.auth.FirebaseUser
import com.jbaloji.biblequiz.R

@Composable
fun ProfileCard(
    user:FirebaseUser
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box() {
            Icon(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Profile Image" )
        }
        Text(text = user.displayName.toString())
        Text(text = "user Description")

    }

}

