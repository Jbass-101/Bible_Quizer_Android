package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.components.shimmerEffect

@Composable
fun QuestionShimmer(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .padding(12.dp,0.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f)
            ){
                Box(modifier = Modifier
                    .width(50.dp)
                    .height(25.dp)
                    .shimmerEffect())

                Box(modifier = Modifier
                    .width(125.dp)
                    .height(25.dp)
                    .shimmerEffect())

                Box(modifier = Modifier
                    .width(50.dp)
                    .height(25.dp)
                    .shimmerEffect())
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f)
            ){
                Box(modifier = Modifier
                    .width(50.dp)
                    .height(25.dp)
                    .shimmerEffect())

                Box(modifier = Modifier
                    .width(200.dp)
                    .height(25.dp)
                    .shimmerEffect())

                Box(modifier = Modifier
                    .width(50.dp)
                    .height(25.dp)
                    .shimmerEffect())
            }

            Box(modifier = Modifier
                .shimmerEffect()
                .weight(0.3f)
                .fillMaxWidth())



            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f)
            ){
                Box(modifier = Modifier
                    .width(100.dp)
                    .height(25.dp)
                    .shimmerEffect())

                Box(modifier = Modifier
                    .width(100.dp)
                    .height(25.dp)
                    .shimmerEffect())
            }

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
            ){
                for(i in 1..4){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(ButtonDefaults.MinHeight)
                        .shimmerEffect())
                }

            }
            
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()) {
                for(i in 1..2){
                    Box(modifier = Modifier
                        .width(ButtonDefaults.MinWidth)
                        .height(ButtonDefaults.MinHeight)
                        .shimmerEffect())
                }
                
            }

        }

    }

}

@Preview(name = "Question Shimmer")
@Composable
fun Question_Shimmer(){
    QuestionShimmer()
}