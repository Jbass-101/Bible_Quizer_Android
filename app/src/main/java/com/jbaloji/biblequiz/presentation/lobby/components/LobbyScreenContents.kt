package com.jbaloji.biblequiz.presentation.lobby.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jbaloji.biblequiz.components.FeatureCard
import com.jbaloji.biblequiz.components.GenericButton
import com.jbaloji.biblequiz.domain.model.Feature
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.components.BackgroundImage
import com.jbaloji.biblequiz.theme.BibleQuizTheme

@Composable
fun LobbyScreenContents(
    feature : List<Feature>,
    onNavigateToHome : () -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxSize(),

    ) {

        BackgroundImage(image = R.drawable.main_bg)
        Column(
            modifier = Modifier
                .safeContentPadding()
                .padding(12.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                modifier = Modifier
                    .weight(0.1f),
                text = stringResource(id = R.string.select_game_mode),
                fontSize = 20.sp
            )

            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f),){

                items(feature.size){ index ->

                    FeatureCard(
                        text = feature[index].name,
                        icon = feature[index].icon,
                        onClick =  feature[index].onClick
                    )
                }
            }

            GenericButton(
                text = stringResource(id = R.string.home_btn_text) ,
                action = onNavigateToHome
            )

        }

    }
}

@Preview(name = "Lobby Screen")
@Composable
fun Lobby_Screen(){
    BibleQuizTheme() {
        LobbyScreenContents(feature = listOf(
            Feature(
                name = "Feature 1",
                icon = R.drawable.timer_icon_200,
                onClick = { }
            ),
            Feature(
                name = "Feature 2",
                icon = R.drawable.timer_icon_200,
                onClick = { }
            ),
            Feature(
                name = "Feature 3",
                icon = R.drawable.timer_icon_200,
                onClick = { }
            ),
            Feature(
                name = "Feature 4",
                icon = R.drawable.timer_icon_200,
                onClick = { }
            ),
        )) {

        }
        
    }
}