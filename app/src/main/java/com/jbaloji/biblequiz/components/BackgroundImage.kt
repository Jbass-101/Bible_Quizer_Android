package com.jbaloji.biblequiz.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun BackgroundImage(
    image : Int
){
    Image(painter = painterResource(id = image) ,
        contentDescription = "main background",
        contentScale = ContentScale.Crop)

}