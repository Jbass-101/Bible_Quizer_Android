package com.jbaloji.biblequiz.presentation.features.timedQuiz.score.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jbaloji.biblequiz.components.GenericButton

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

        ) {
            Text(
                text = score.toString(),
                fontSize = 25.sp
            )
            Text(
                text = "Your Score"
            )
            Spacer(modifier = Modifier.padding(30.dp))
            if (score > 8) {
                Text(text = "New level unlocked!")
            } else {
                Text(text = "Score at least 9 to unlock the next level")
            }
            Spacer(modifier = Modifier.padding(15.dp))
            GenericButton(
                text = "Select Level",
                action = onNavigateToLevels
            )
            GenericButton(
                text = "Home",
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