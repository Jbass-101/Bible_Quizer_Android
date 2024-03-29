package com.jbaloji.biblequiz.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(
    title : String = "My Title",
    description : String = stringResource(id = R.string.sampleQuestion),
    onReadMore: () -> Unit
){
    var expandState by remember { mutableStateOf(false) }
    val rotateState by animateFloatAsState(targetValue = if (expandState) 180f else 0f)
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .clickable {expandState = !expandState  },

        shape = MaterialTheme.shapes.medium,
//        onClick = {expandState = !expandState}
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                    Icon(
                    modifier = Modifier
                        .alpha(100f)
                        .weight(1f)
                        .rotate(rotateState),
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow" )

            }
            if(expandState){
                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                    .padding(1.dp)
                ) {
                    Text(
                        text = description,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis)
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = onReadMore) {
                            Text(text = "Read more")

                    }
                        
                    }
                    
                }
            }

        }
        
    }
}


@Preview(name = "Expandable Card")
@Composable
fun ExpandableCardScreen(){
    Column(
        
    ) {
        ExpandableCard(){

        }
        Spacer(modifier = Modifier.height(23.dp))
        ExpandableCard(){

        }

    }
}