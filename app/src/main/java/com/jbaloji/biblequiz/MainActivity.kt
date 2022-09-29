package com.jbaloji.biblequiz

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.Presentation.Components.DefaultButton
import com.jbaloji.biblequiz.Presentation.Components.TitleText
import com.jbaloji.biblequiz.ui.theme.BibleQuizTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibleQuizTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    Scaffold(
    ) {
        Column (
            modifier = Modifier
            //.background(color = colorResource(id = R.color.purple_200))
        ){
            Box(
                modifier = Modifier
                    //.background(color = colorResource(id = R.color.teal_200))
                    .fillMaxWidth(1f)
                    .heightIn(450.dp),
                contentAlignment = Alignment.Center

            ) {
                Text(text = "Question Number")
                
                Text(text = stringResource(id = R.string.sampleQuestion))
                
            }
            Box(
                modifier = Modifier
                    //.background(color = colorResource(id = R.color.teal_200))
                    .fillMaxWidth(1f)
                    .heightIn(450.dp),
                contentAlignment = Alignment.Center

            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    DefaultButton(stringResource(id = R.string.Sample_Answer_1))
                    Spacer(
                        modifier = Modifier
                            .height(25.dp)
                    )
                    DefaultButton(stringResource(id = R.string.Sample_Answer_2))
                    Spacer(
                        modifier = Modifier
                            .height(25.dp)
                    )
                    DefaultButton(stringResource(id = R.string.Sample_Answer_3))
                    Spacer(
                        modifier = Modifier
                            .height(25.dp)
                    )
                    DefaultButton(stringResource(id = R.string.Sample_Answer_4))

                }
            }

        }
    }
}


@Preview(
    name = "light mode",
    showBackground = true)
@Preview(
    name = "Dark Mode",
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
fun DefaultPreview() {
    BibleQuizTheme {
        Greeting()
    }
}