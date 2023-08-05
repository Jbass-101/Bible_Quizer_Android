package com.jbaloji.biblequiz.presentation.features.firmFoundation.contents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jbaloji.biblequiz.components.ExpandableCard

@Composable
fun ContentsScreen(){

    val titles = arrayOf( "Salvation", "Be Sure of your salvation", "Confessing Christ Publically", "Read the Bible", "Fellowship", "Giving (Tithe and Offerings)")

    LazyColumn(
        content = {
            items(titles.size){item ->
                ExpandableCard(titles[item])
            }
        }

    )

}

@Preview(name = "ContentsPage")
@Composable
fun ContentsScreenPreview(){
    ContentsScreen()
}

