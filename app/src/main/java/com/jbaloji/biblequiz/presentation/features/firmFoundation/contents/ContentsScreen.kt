package com.jbaloji.biblequiz.presentation.features.firmFoundation.contents

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.components.ExpandableCard

@Composable
fun ContentsScreen(){

    val titles = arrayOf( "Salvation", "Be Sure of your salvation", "Confessing Christ Publicly", "Read the Bible", "Fellowship", "Giving (Tithe and Offerings)")

    LazyColumn(
        content = {
            items(titles.size){item ->
                ExpandableCard(titles[item])
                Spacer(modifier = Modifier.height(12.dp))
            }
        }

    )

}

@Preview(name = "ContentsPage")
@Composable
fun ContentsScreenPreview(){
    ContentsScreen()
}

