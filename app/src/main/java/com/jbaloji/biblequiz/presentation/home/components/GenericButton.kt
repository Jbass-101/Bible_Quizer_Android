package com.jbaloji.biblequiz.presentation.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R


@Composable
fun GenericButton (
    text: String,
    action : () -> Unit,
    enabled : Boolean = true,
    paddingSize : Dp = 0.dp
){
    Button(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(vertical = paddingSize),
        onClick = action,
        enabled = enabled
    ) {
        if(!enabled){
            Icon(
                painter = painterResource(id = R.drawable.lock_icon_24) ,
                contentDescription = "Locked" )
        }
        Text(text = text)
        
    }

}

