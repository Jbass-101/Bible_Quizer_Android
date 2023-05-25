package com.jbaloji.biblequiz.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.jbaloji.biblequiz.domain.model.BibleVerse
import com.jbaloji.biblequiz.theme.Shapes

@Composable
fun BibleVersePopUp(
    showDialog: Boolean,
    verseTitle: String,
    bibleVerse: BibleVerse,
    onDismiss: () -> Unit
){
    if(showDialog){


        Popup(
            alignment = Alignment.Center,
            onDismissRequest = onDismiss
        ) {
            Card(
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.inversePrimary,
                        shape = MaterialTheme.shapes.medium
                    )
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(0.5f),
//                    .padding(12.dp),
                shape = Shapes.medium
            ) {
                Column(
                    modifier = Modifier
//                        .padding(12.dp)
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = MaterialTheme.shapes.medium
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = verseTitle,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Box(modifier = Modifier
                        .weight(0.1f)
                        .padding(12.dp)

                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                                color = MaterialTheme.colorScheme.inversePrimary,
                            shape = MaterialTheme.shapes.medium
                        )

                    ){
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            userScrollEnabled = true
                        ){
                            if(bibleVerse.verse.isNotEmpty()){
                                item {
                                    var startVerse = bibleVerse.startVerse
                                    bibleVerse.verse.forEach {
                                        Text(text = buildAnnotatedString {
                                            append(
                                                AnnotatedString(
                                                    text = "$startVerse ",
                                                    spanStyle = SpanStyle(
                                                        baselineShift = BaselineShift.Superscript,
                                                        fontWeight = FontWeight.Bold,
                                                    )
                                                )
                                            )
                                            append(it)
                                        })
                                        startVerse++
                                    } }

                            } else {
                                item {
                                    CircularProgressIndicator() }
                            }
                        }

                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 12.dp, bottom = 12.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = onDismiss) {
                            Text(text = "Close")

                        }

                    }

                }

            }


        }

    }

}

@Preview(name = "Pop Up")
@Composable
fun BibleVerse_Popup(){
    BibleVersePopUp(
        showDialog = true,
        verseTitle = "Genesis 1 : 1",
        bibleVerse = BibleVerse(),
        onDismiss = {}
    )
}