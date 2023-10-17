package com.jbaloji.biblequiz.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.theme.BibleQuizTheme

@Composable
fun LevelCard(
    text: String,
    action : () -> Unit,
    enabled : Boolean = true,){
    Box(
        modifier = Modifier
            .height(62.dp),) {
        Box(
            contentAlignment = Alignment.Center
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
                    text = text,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        if(enabled){
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ){
                Row(


                ) {
                    Icon(painter = painterResource(id = R.drawable.baseline_star_rate_24), contentDescription = "Star" )
                    Icon(painter = painterResource(id = R.drawable.baseline_star_outline_24), contentDescription = "Star" )
                    Icon(painter = painterResource(id = R.drawable.baseline_star_outline_24), contentDescription = "Star" )
                    Icon(painter = painterResource(id = R.drawable.baseline_star_outline_24), contentDescription = "Star" )
                    Icon(painter = painterResource(id = R.drawable.baseline_star_outline_24), contentDescription = "Star" )

                }
            }

        }
        
    }
    
}


@Composable
@Preview(name = "Level Card")
fun LevelCardPreview(){
    BibleQuizTheme {
        LevelCard(text = "Hello", action = { /*TODO*/ })
        
    }
}