package com.jbaloji.biblequiz.presentation.features.timedQuiz.questions.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.components.GenericButton
import com.jbaloji.biblequiz.domain.model.Question

@Composable
fun QuestionsScreenContents(
    q : Question,
    options : List<String>,
    currentScore: Int,
    currentQuestionNumber: Int,
    totalQuestions: Int,
    totalHints: Int,
    showHint: Boolean,
    isLastQuestion: Boolean,
    hasAnswered: Boolean,
    randomise: (List<String>) -> List<String>,
    answerQuestion: (Boolean) -> Unit,
    toggleDialog : () -> Unit,
    toggleHint: () -> Unit,
    onNext : () -> Unit,
    onComplete : () -> Unit
){

    LaunchedEffect(q.options){
        randomise(q.options)
    }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Column() {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
            ) {
                Text(text = "Score: $currentScore")
                Text(text = "Question $currentQuestionNumber/$totalQuestions")
                Text(text = "Hints : $totalHints")
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth(1f)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_timer),
                    contentDescription = "Count Down Timer")
                Spacer(Modifier.width(ButtonDefaults.IconSpacing))
                //Progress Bar
                LinearProgressIndicator(
                    progress = animateFloatAsState(
                        targetValue = 1f,
                        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
                    ).value
                )
                Spacer(Modifier.width(ButtonDefaults.IconSpacing))
                Text(text = "59" )

            }
            Card(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.3f)
                    .weight(0.3f)
                ,) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    fontSize = 19.sp,
                    textAlign = TextAlign.Center,
                    text = q.question
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
            ) {
                if(showHint){
                    Text(text = q.hint)
                } else {
                    Text(text = "")
                }
                TextButton(onClick = { toggleHint() }) {
                    Text(text = "Show Hint")
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Icon(painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = "Show Hint")
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
//                GenericButton(text = q.options[0], action = { /*TODO*/ })
//                GenericButton(text = q.options[1], action = { /*TODO*/ })
//                GenericButton(text = q.options[2], action = { /*TODO*/ })
//                GenericButton(text = q.options[3], action = { /*TODO*/ })
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(0.1f)
                    .fillMaxWidth()
            ){
                TextButton(onClick = toggleDialog) {
                    Text(text = "Quit")
                }
                if(isLastQuestion){
                    TextButton(onClick = onComplete) {
                        Text(text = "Finish")
                    }
                } else {
                    TextButton(onClick = onNext) {
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
            "This is the question",
            "This is the Answer",
            "This is the hint",
            "This is the book",
            listOf<String>(
                "Answer 1", "Answer 2","Answer 3", "Answer 4"
            )
        ),
        options =
        listOf<String>(
            "Answer 1", "Answer 2","Answer 3", "Answer 4"
        ) ,
        randomise = {
            listOf<String>(
                "Answer 1", "Answer 2","Answer 3", "Answer 4"
            )},
        onNext = {},
        onComplete = {},
        toggleHint = {},
        toggleDialog = {},
        answerQuestion = {},
        currentQuestionNumber = 5,
        currentScore = 5,
        totalHints = 5,
        totalQuestions = 15,
        showHint = true,
        isLastQuestion = false,
        hasAnswered = false
    )
}