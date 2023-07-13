package com.jbaloji.biblequiz.presentation.features.timedQuiz.score.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.components.GenericButton
import com.jbaloji.biblequiz.R

@Composable
fun ScoreScreenContents(
    score: Int,
    onNavigateToHome: () -> Unit,
    onNavigateToLevels: () -> Unit,
){

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize(1f)
                .safeContentPadding()
                .padding(12.dp, 0.dp),

        ) {
            Text(
                text = stringResource(id =R.string.your_score_text )
            )
            Text(
                text = score.toString(),
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.padding(30.dp))
            if (score > 8) {
                Text(text = stringResource(id = R.string.level_unlocked_text))
            } else {
                Text(text = stringResource(id = R.string.min_score_txt))
            }
            Spacer(modifier = Modifier.padding(15.dp))
            GenericButton(
                text = stringResource(id = R.string.select_level_txt),
                action = onNavigateToLevels
            )
            GenericButton(
                text = stringResource(id = R.string.home_btn_text),
                action = onNavigateToHome
            )

        }
    }
    
}

@Preview(name = "Score Screen")
@Composable
fun Score_Screen(){
    ScoreScreenContents(score = 15, onNavigateToHome = { /*TODO*/ }) {
        
    }
}