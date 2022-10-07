package com.jbaloji.biblequiz.presentation.questions.components

import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun TitleText(){
    Text(
        text = stringResource(id = R.string.app_name),
        fontSize = 40.sp,
        color = MaterialTheme.colors.primaryVariant

    )

}


@Preview(
    name = "light mode",
    showBackground = true)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun TitlePreview() {
    BibleQuizTheme {
        TitleText()
    }
}