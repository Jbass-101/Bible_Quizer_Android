package com.jbaloji.biblequiz.presentation.home

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.components.ProgressBar
import com.jbaloji.biblequiz.navigation.Screens
import com.jbaloji.biblequiz.presentation.home.components.HomeContents
import com.jbaloji.biblequiz.presentation.home.components.HomeScreenContents
import com.jbaloji.biblequiz.presentation.questions.components.TitleText
import com.jbaloji.biblequiz.presentation.theme.BibleQuizTheme

@Composable
fun HomeScreen(
    navController: NavController
) {
    BibleQuizTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background,
            content = {paddingValues ->

                Box(){
                    Image(
                        painter = painterResource(id = R.drawable.background ),
                        contentDescription = "background",
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box() {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(paddingValues)
                                .fillMaxSize()

                        ) {
                            HomeScreenContents (
                                contents = {
                                    TitleText()
                                    Button(onClick = {
                                        navController.navigate(Screens.Questions.route)
                                    }) {
                                        Text(text = "Start")
                                    }
                                    Button(onClick = { /*TODO*/ }) {
                                        Text(text = "Feature 1")
                                    }
                                    Button(onClick = { /*TODO*/ }) {
                                        Text(text = "Feature 2")
                                    }
                                    Button(onClick = { /*TODO*/ }) {
                                        Text(text = "Feature 3")
                                    }


                                }
                            )


                        }

                    }
                }


            }

        )
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
        HomeScreen(navController = rememberNavController())
    }
}

