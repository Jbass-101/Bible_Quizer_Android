package com.jbaloji.biblequiz.presentation.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.jbaloji.biblequiz.presentation.home.HomeScreen
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme


@Composable
fun GenericButton (
    text: String,
    navigation : () -> Unit
){
    Button(
        modifier = Modifier.fillMaxWidth(0.5f),
        onClick = navigation
    ) {
        Text(text = text)
        
    }

}


@Preview(
    name = "light mode",
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    BibleQuizTheme() {
//        GenericButton()

    }
}