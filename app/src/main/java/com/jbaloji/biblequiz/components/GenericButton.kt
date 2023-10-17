package com.jbaloji.biblequiz.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.theme.BibleQuizTheme


@Composable
fun GenericButton (
    text: String,
    action : () -> Unit,
    enabled : Boolean = true,
    paddingSize : Dp = 0.dp,
    textPadding : Dp = 0.dp,
    secondary: Boolean = false,

){
    Button(
        modifier = Modifier
            .width(200.dp)
            .height(50.dp),

        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp

        ),
        onClick = action,
        enabled = enabled,
        shape = RoundedCornerShape(8.dp)
    ) {
        if(!enabled){
            Icon(
                painter = painterResource(id = R.drawable.lock_icon_24) ,
                contentDescription = "Locked" )
        }
        Text(
            modifier = Modifier
                .padding(textPadding),
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
        
    }

}


@Preview(name = "Generic Button", device = Devices.NEXUS_6 )
@Preview(name = "Generic Button Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Home_Screen(){
    BibleQuizTheme() {
        GenericButton(text = "Hello", action = { /*TODO*/ })

    }

}

