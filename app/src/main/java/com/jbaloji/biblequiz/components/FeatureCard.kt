package com.jbaloji.biblequiz.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R

@Composable
fun FeatureCard(
    text: String,
    index: Int,
    onClick: (() -> Unit)?
){
    val icon = "icon"
    val desc = "desc"
    val color = "color"
     val iconMap = mapOf(
        0 to mapOf(
            icon to R.drawable.timer_icon_200,
            desc to "Timer Icon",
            color to Color.Blue
        ),
//        1 to mapOf(
//            "icon" to R.drawable.timer_icon_200,
//            "desc" to "Timer Icon",
//            "color" to Color.Red
//        ),
//         2 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Green
//         ),
//         3 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Yellow
//         ),
//         4 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Cyan
//         ),
//         5 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Blue
//         ),
//         6 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Red
//         ),
//         7 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Yellow
//         ),
//         8 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Green
//         ),
//         9 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Blue
//         ),
//         10 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Red
//         ),
//         11 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Green
//         ),
//         12 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Yellow
//         ),
//         13 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Cyan
//         ),
//         14 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Blue
//         ),
//         15 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Red
//         ),
//         16 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Yellow
//         ),
//         17 to mapOf(
//             "icon" to R.drawable.timer_icon_200,
//             "desc" to "Timer Icon",
//             "color" to Color.Green
//         )
    )

    Card(
        modifier = Modifier.clickable (
            onClick = { onClick?.invoke() }
                )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = iconMap[index]?.get(icon) as Int) ,
                contentDescription = iconMap[index]?.get(desc) as String,
                modifier = Modifier.size(150.dp)
            )
            Text(
                modifier = Modifier
                   // .background(iconMap[index]?.get(color) as Color)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = text
            )

        }

    }

}