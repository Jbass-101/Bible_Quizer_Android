package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.domain.model.BibleVerse
import com.jbaloji.biblequiz.domain.model.Question

@Composable
fun QuestionsScreenContents(
    q : Question,
    score: Int,
    questionNumber: Int,
    totalQuestions: Int,
    totalHints: Int,
    progress : Float,
    time: Int,
    hint: Boolean,
    hasAnswered: Boolean,
    isLastQuestion: Boolean,
    answerQuestion: (Boolean) -> Unit,
    toggleDialog : () -> Unit,
    onShowHint: () -> Unit,
    onNext : () -> Unit,
    onNavigateToScore : () -> Unit,
    getVerse : (String) -> Unit,
    toggleVerseDialog : () -> Unit
){

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .padding(12.dp, 0.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
            ) {
                Text(text = "Score: $score")
                Text(text = "Question $questionNumber/$totalQuestions")
                Text(text = "Hints : $totalHints")
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth(1f)
            ) {
                //ICON
                Icon(painter = painterResource(id = R.drawable.ic_timer),
                    contentDescription = "Count Down Timer")
                //Progress Bar
                LinearProgressIndicator(
                    progress = animateFloatAsState(
                        targetValue = progress,
                        animationSpec = tween(
                            durationMillis = 1100,
                            easing = EaseOut
                        )
                    ).value,
                    color = when(time){
                        60 -> animateColorAsState(
                            targetValue = Color.Green,
                            animationSpec = tween(
                                durationMillis = 1000,
                                easing = LinearEasing
                            ),
                        ).value
                        else -> animateColorAsState(
                            targetValue = if(time < 55) Color.Red else Color.Green,
                            animationSpec = tween(
                                durationMillis = 54000,
                                easing = LinearEasing
                            ),
                        ).value
                    }
                )
                //TEXT TIME
                Text(text = time.toString() )

            }
            Card(
                modifier = Modifier
//                    .fillMaxSize()
                    .weight(0.3f)

                ,) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    LazyColumn(content = {
                        item {
                            Text(
                                textAlign = TextAlign.Center,
                                text = q.question,
                                style = MaterialTheme.typography.bodyLarge
                            )

                        }
                    })

                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
            ) {
                TextButton(onClick = {
                    onShowHint()
                }) {
                    Text(text = "Show Hint")
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Icon(painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = "Show Hint")
                }
                AnimatedVisibility(
                    visible = hint,
                ) {
                    TextButton(
                        onClick = {
                            getVerse(q.hint)
                        toggleVerseDialog()
                        }) {
                        Text(text = q.hint)

                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.weight(0.5f)) {
                for(option in q.options){
                    AnswerButton(
                        hasAnswered = hasAnswered,
                        option = option,
                        answer = q.answer,
                        answerQuestion = {
                            answerQuestion(it)
                        }
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
            ){
                TextButton(
                    onClick = toggleDialog) {
                    Text(text = "Quit")
                }
                if(isLastQuestion){
                    TextButton(
                        enabled = hasAnswered,
                        onClick = onNavigateToScore) {
                        Text(text = "Finish")
                    }
                } else {
                    TextButton(
                        enabled = hasAnswered,
                        onClick = onNext ) {
                        Text(text = "Next")
                    }

                }
            }
        }
    }
}

@Preview("Question Screen")
@Composable
fun Question_Screen(){
    QuestionsScreenContents(
        Question(
            "This is the question | This is the question | This is the question | This is the question |",
            "This is the Answer",
            "This is the hint",
            "This is the book",
            listOf<String>(
                "Answer 1", "Answer 2","Answer 3", "Answer 4"
            )
        ),
        onNext = {},
        onNavigateToScore = {},
        onShowHint = {},
        toggleDialog = {},
        answerQuestion = {},
        getVerse = {},
        toggleVerseDialog = {},
        questionNumber = 5,
        score = 5,
        totalHints = 5,
        totalQuestions = 15,
        isLastQuestion = false,
        hint = true,
        progress = 0.5f,
        time = 30,
        hasAnswered = false,
    )
}