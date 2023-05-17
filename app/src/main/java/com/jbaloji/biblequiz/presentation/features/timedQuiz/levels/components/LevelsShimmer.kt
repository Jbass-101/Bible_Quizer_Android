package com.jbaloji.biblequiz.presentation.features.timedQuiz.levels.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.components.GenericButton
import com.jbaloji.biblequiz.components.shimmerEffect
import com.jbaloji.biblequiz.navigation.Screen

@Composable
fun LevelShimmer(){


    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .safeContentPadding()
                .padding(12.dp,0.dp),) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f)){
                Box(
                    modifier = Modifier
                        .shimmerEffect()
                        .width(125.dp)
                        .height(25.dp)
                )
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(0.9f),
                userScrollEnabled = true
            ){
                items(20){
                    Box(modifier = Modifier
                        .shimmerEffect()
                        .height(ButtonDefaults.MinHeight)
                        .fillMaxWidth())

                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.12f),
                contentAlignment = Alignment.Center
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ButtonDefaults.MinHeight)
                        .shimmerEffect())
            }
            
        }
    }

}

@Preview(name = "Question Shimmer")
@Composable
fun Level_Shimmer(){
    LevelShimmer()
}