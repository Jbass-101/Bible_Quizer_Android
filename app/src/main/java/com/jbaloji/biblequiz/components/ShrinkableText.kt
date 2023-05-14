package com.jbaloji.biblequiz.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.text.TextStyle

@Composable
fun ShrinkableText(
    text: String,
    style: TextStyle = MaterialTheme.typography.displayLarge,
){
    var resizedText by remember {
        mutableStateOf(style)
    }

    var shouldDraw by remember {
        mutableStateOf(false)
    }
    
    Column() {
        Text(
            modifier = Modifier.drawWithContent {
                if (shouldDraw){
                    drawContent()
                }
            },
            style = resizedText,
            text = text,
            softWrap = false,
            onTextLayout = {
                if(it.didOverflowWidth){
                    resizedText = resizedText.copy(
                        fontSize = resizedText.fontSize * 0.95
                    )
                }else{
                    shouldDraw =true
                }
            }
        )
        
    }
    

}