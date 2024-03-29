package com.jbaloji.biblequiz.presentation.features.firmFoundation.lesson.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.domain.model.Lesson
import com.jbaloji.biblequiz.domain.repository.Lessons
import java.sql.RowId

@Composable
fun LessonScreenContents (
    lessons : Lessons,
    getVerse : (String) -> Unit,
    toggleVerseDialog : () -> Unit
){
    Surface(modifier = Modifier
        .fillMaxSize()) {
        Column(modifier = Modifier
            .safeContentPadding()
            .padding(12.dp, 0.dp)) {
            Text(text = "Lesson Text")
            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn(content = {
                items(lessons.size){i ->
                    Column() {
                        val text = buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                fontWeight = FontWeight.Bold
                            )){
                                append("${i + 1}. ")
                            }
                            withStyle(style = SpanStyle(

                            )){
                                append(lessons[i].notes)
                            }
                        }
                        Text(text = text)
                        Row() {
                            Text(text = "Refs:")
                            Spacer(modifier = Modifier.width(8.dp))
                            LazyRow() {
                                items(lessons[i].ref.size){j ->
                                    val ref = lessons[i].ref[j]
                                    Text(
                                        text = ref ,
                                        textDecoration = TextDecoration.Underline,
                                        color = MaterialTheme.colorScheme.secondary,
                                        modifier = Modifier.clickable {
                                            getVerse(ref)
                                            toggleVerseDialog()
                                        }
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))

                    }
                }
            })
        }

    }

}


@Preview("Lesson Screen")
@Composable
fun Lesson_Screen(){
    LessonScreenContents(
        lessons = listOf<Lesson>(
            Lesson(
            notes = stringResource(id = com.jbaloji.biblequiz.R.string.sampleQuestion),
            ref = listOf(
                stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_1),
                stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_2)
            )
            ),
            Lesson(
                notes = stringResource(id = com.jbaloji.biblequiz.R.string.sampleQuestion),
                ref = listOf(
                    stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_1),
                    stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_2),
                    stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_1),
                    stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_2),
                )
            ),
            Lesson(
                notes = stringResource(id = com.jbaloji.biblequiz.R.string.sampleQuestion),
                ref = listOf(
                    stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_1),
                    stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_2)
                )
            ),
            Lesson(
                notes = stringResource(id = com.jbaloji.biblequiz.R.string.sampleQuestion),
                ref = listOf(
                    stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_1),
                    stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_2),
                    stringResource(id = com.jbaloji.biblequiz.R.string.Sample_Ref_1)
                )
            ),
        ),
        getVerse = {

        },
        toggleVerseDialog = {

        }
    )
}