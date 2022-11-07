package com.jbaloji.biblequiz.presentation.lobby

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.components.FeatureCard
import com.jbaloji.biblequiz.presentation.home.components.GenericButton

@Composable
fun LobbyScreen(
    onNavigateToLevels: () -> Unit,    
){
    val text = "text"
    val onClick ="onClick"

    val list = mapOf(
        0 to mapOf(
            text to "Timed Quiz",
            onClick to onNavigateToLevels
        ),
//        1 to onNavigateToLevels,
//        2 to onNavigateToLevels,
//        3 to onNavigateToLevels,
//        4 to onNavigateToLevels,
//        5 to onNavigateToLevels,
//        6 to onNavigateToLevels,
//        7 to onNavigateToLevels,
//        8 to onNavigateToLevels,
//        9 to onNavigateToLevels,
//        10 to onNavigateToLevels,
//        11 to onNavigateToLevels,
//        12 to onNavigateToLevels,
//        13 to onNavigateToLevels,
//        14 to onNavigateToLevels,
//        15 to onNavigateToLevels,
//        16 to onNavigateToLevels,
//        17 to onNavigateToLevels,
    )

    LazyVerticalGrid(
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center,
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        modifier = Modifier.fillMaxSize(),
        content = {

            items(list.size){ item ->
                @Suppress("UNCHECKED_CAST")
                FeatureCard(
                    text = list[item]?.get(text) as String,
                    index = item,
                    onClick =  list[item]?.get(onClick) as () -> Unit
                )

            }
        }
    )
}