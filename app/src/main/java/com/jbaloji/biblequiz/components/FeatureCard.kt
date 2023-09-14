package com.jbaloji.biblequiz.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.theme.md_theme_dark_shadow

@Composable
fun FeatureCard(
    text: String,
    icon: Int,
    onClick: () -> Unit

){
    Surface(
        modifier = Modifier
            .clickable ( onClick = onClick )
            .height(200.dp)
            .padding(0.dp,10.dp)
            .shadow(
                elevation = 5.dp,
//                ambientColor = MaterialTheme.colorScheme.scrim,
                spotColor = MaterialTheme.colorScheme.scrim,
                shape = RoundedCornerShape(20.dp)
            ),
        shape = RoundedCornerShape(5.dp),
        tonalElevation = 5.dp,) {
        Card(
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = icon) ,
                    contentDescription = icon.toString(),
                    modifier = Modifier.size(125.dp)
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = text,
                    style = MaterialTheme.typography.headlineSmall

                )

            }

        }

    }

}

