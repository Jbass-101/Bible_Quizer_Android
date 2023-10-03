package com.jbaloji.biblequiz.presentation.features.firmFoundation.contents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.components.ExpandableCard
import com.jbaloji.biblequiz.components.GenericButton

@Composable
fun ContentsScreen(
    onNavigateToLobby : () -> Unit,
    onNavigateToLesson: () -> Unit
){

    val titles = arrayOf( "Salvation", "Be Sure of your salvation", "Confessing Christ Publicly", "Read the Bible", "Fellowship", "Giving (Tithe and Offerings)")

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .padding(12.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                modifier = Modifier.weight(0.1f),
                text = "The Christian Doctrine",
                style = MaterialTheme.typography.titleMedium
            )
            LazyColumn(
                modifier = Modifier.weight(1f),
                content = {
                    items(titles.size){item ->
                        ExpandableCard(titles[item]){
                            onNavigateToLesson()
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }

                }

            )

            GenericButton(
                text = "Home" ,
                action = onNavigateToLobby
            )

        }

    }


}

@Preview(name = "ContentsPage")
@Composable
fun ContentsScreenPreview(){
    ContentsScreen(
        onNavigateToLobby = {},
        onNavigateToLesson = {}
    )
}

