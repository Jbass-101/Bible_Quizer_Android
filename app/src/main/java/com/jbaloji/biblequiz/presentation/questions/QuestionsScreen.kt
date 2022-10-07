package com.jbaloji.biblequiz.presentation.questions

import android.content.res.Configuration
import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jbaloji.biblequiz.presentation.questions.components.*
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun QuestionsScreen(
    viewModel: QuestionsViewModel = hiltViewModel()
) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        content = {paddingValues ->
            Column(
                Modifier
                    .fillMaxSize(1f)
                    .padding(25.dp, 12.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                QuestionNumberText()
                MySpacer()
                QuestionText()
                MySpacer()
                HintText()
                MySpacer()
                AnswerButtonContainer()
                MySpacer()
                MiscButtonContainer()
                MySpacer()
                MySpacer()

            }

        }

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
fun DefaultPreview() {
    BibleQuizTheme {
        Scaffold(
            backgroundColor = MaterialTheme.colors.background,
            content = {paddingValues ->
                Column(
                    Modifier
                        .fillMaxSize(1f)
                        .padding(25.dp, 12.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    MySpacer()
                    QuestionNumberText()
                    MySpacer()

                    QuestionText()

                    MySpacer()
                    HintText()
                    MySpacer()
                    AnswerButtonContainer()
                    MySpacer()
                    MySpacer()
                    MiscButtonContainer()
                    MySpacer()
                    MySpacer()

                }

            }

        )
    }
}
