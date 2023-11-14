import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jbaloji.biblequiz.components.GenericButton
import com.jbaloji.biblequiz.components.LevelCard
import com.jbaloji.biblequiz.domain.model.TimedQuizScore
import com.jbaloji.biblequiz.navigation.Screen
import com.jbaloji.biblequiz.theme.BibleQuizTheme


@Composable
fun LevelsScreenContents(
    navController: NavController,
    quizScore : TimedQuizScore
){
    val passingScore = 8

    Surface(
        modifier = Modifier
            .fillMaxSize() ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .safeContentPadding()
                .padding(12.dp, 0.dp),
        ) {
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = stringResource(id = com.jbaloji.biblequiz.R.string.select_level_txt),
                    style = MaterialTheme.typography.titleMedium
                )

            }


            LazyVerticalGrid(
//                verticalArrangement = Arrangement.spacedBy(5.dp),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                userScrollEnabled = true,
                modifier = Modifier.weight(8f,),
                content = {
                    items(quizScore.score.size) { item ->
                        LevelCard(
                            text = stringResource(id = com.jbaloji.biblequiz.R.string.level_txt) + " " + (item + 1).toString() ,
                            action = {
//                                navController.navigate(
//                                    list[item]?.get(path) as String
//                                )
                            },
                            enabled = if(item == 0) true else {
                                quizScore.score[item - 1] > passingScore
                            }
                        )
                    }
                }
            )
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {

                GenericButton(
                    text = stringResource(id = com.jbaloji.biblequiz.R.string.back_btn_text),
                    action = {
                        navController.navigate(Screen.Lobby) {
                            popUpTo(Screen.Lobby)
                        }
                    }
                )

            }
        }
    }

}

@Preview(name = "Levels Screen")
@Composable
fun Levels_Screen(){
    BibleQuizTheme() {
        LevelsScreenContents(navController = rememberNavController( ), quizScore = TimedQuizScore(
            score = listOf(
                10,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
            )

        ))

    }
}