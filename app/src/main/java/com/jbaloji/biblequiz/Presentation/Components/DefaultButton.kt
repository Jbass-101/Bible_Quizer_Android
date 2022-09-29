package com.jbaloji.biblequiz.Presentation.Components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.Greeting
import com.jbaloji.biblequiz.ui.theme.BibleQuizTheme
import com.jbaloji.biblequiz.ui.theme.Shapes

@Composable
fun DefaultButton(text : String){
    Button(
        shape = RoundedCornerShape(15.dp),

        onClick = { /*TODO*/ }) {
        Text(
            text = text)

    }

}


@Preview(
    name = "light mode",
    showBackground = true)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun ButtonPreview() {
    BibleQuizTheme {
        DefaultButton("junior")
    }
}
