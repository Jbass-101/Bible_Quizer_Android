import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.jbaloji.biblequiz.domain.model.TimedQuizScore
import com.jbaloji.biblequiz.navigation.Screen
import com.jbaloji.biblequiz.navigation.Screen.Level_1
import com.jbaloji.biblequiz.navigation.Screen.Level_10
import com.jbaloji.biblequiz.navigation.Screen.Level_11
import com.jbaloji.biblequiz.navigation.Screen.Level_12
import com.jbaloji.biblequiz.navigation.Screen.Level_13
import com.jbaloji.biblequiz.navigation.Screen.Level_14
import com.jbaloji.biblequiz.navigation.Screen.Level_15
import com.jbaloji.biblequiz.navigation.Screen.Level_16
import com.jbaloji.biblequiz.navigation.Screen.Level_17
import com.jbaloji.biblequiz.navigation.Screen.Level_18
import com.jbaloji.biblequiz.navigation.Screen.Level_19
import com.jbaloji.biblequiz.navigation.Screen.Level_2
import com.jbaloji.biblequiz.navigation.Screen.Level_20
import com.jbaloji.biblequiz.navigation.Screen.Level_3
import com.jbaloji.biblequiz.navigation.Screen.Level_4
import com.jbaloji.biblequiz.navigation.Screen.Level_5
import com.jbaloji.biblequiz.navigation.Screen.Level_6
import com.jbaloji.biblequiz.navigation.Screen.Level_7
import com.jbaloji.biblequiz.navigation.Screen.Level_8
import com.jbaloji.biblequiz.navigation.Screen.Level_9


@Composable
fun LevelsScreenContents(
    navController: NavController,
    score : TimedQuizScore
){
    val path = "path"
    val enabled = "enabled"

    val list = mapOf(
        0 to mapOf(
            path to Level_1 +"/"+score.level_1,
            enabled to 15
        ),
        1 to mapOf(
            path to Level_2 +"/"+score.level_2,
            enabled to score.level_1
        ),
        2 to mapOf(
            path to Level_3 +"/"+score.level_3,
            enabled to score.level_2
        ),
        3 to mapOf(
            path to Level_4 +"/"+score.level_4,
            enabled to score.level_3
        ),
        4 to mapOf(
            path to Level_5 +"/"+score.level_5,
            enabled to score.level_4
        ),
        5 to mapOf(
            path to Level_6 +"/"+score.level_6,
            enabled to score.level_5
        ),
        6 to mapOf(
            path to Level_7 +"/"+score.level_7,
            enabled to score.level_6
        ),
        7 to mapOf(
            path to Level_8 +"/"+score.level_8,
            enabled to score.level_7
        ),
        8 to mapOf(
            path to Level_9 +"/"+score.level_9,
            enabled to score.level_8
        ),
        9 to mapOf(
            path to Level_10 +"/"+score.level_10,
            enabled to score.level_9
        ),
        10 to mapOf(
            path to Level_11 +"/"+score.level_11,
            enabled to score.level_10
        ),
        11 to mapOf(
            path to Level_12 +"/"+score.level_12,
            enabled to score.level_11
        ),
        12 to mapOf(
            path to Level_13 +"/"+score.level_13,
            enabled to score.level_12
        ),
        13 to mapOf(
            path to Level_14 +"/"+score.level_14,
            enabled to score.level_13
        ),
        14 to mapOf(
            path to Level_15 +"/"+score.level_15,
            enabled to score.level_14
        ),
        15 to mapOf(
            path to Level_16 +"/"+score.level_16,
            enabled to score.level_15
        ),
        16 to mapOf(
            path to Level_17 +"/"+score.level_17,
            enabled to score.level_16
        ),
        17 to mapOf(
            path to Level_18 +"/"+score.level_18,
            enabled to score.level_17
        ),
        18 to mapOf(
            path to Level_19 +"/"+score.level_19,
            enabled to score.level_18
        ),
        19 to mapOf(
            path to Level_20 +"/"+score.level_20,
            enabled to score.level_19
        )
    )

    Surface(
        modifier = Modifier
            .fillMaxSize(1f) ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .safeContentPadding()
                .padding(12.dp, 0.dp),
        ) {

                Text(
                    modifier = Modifier
                        .weight(0.1f),
                    text = stringResource(id = com.jbaloji.biblequiz.R.string.select_level_txt),
                    style = MaterialTheme.typography.titleMedium
                )

            LazyColumn(
//                verticalArrangement = Arrangement.spacedBy(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                userScrollEnabled = true,
                modifier = Modifier.weight(1f),
                content = {
                    items(list.size) { item ->
                        GenericButton(
//                            text = list[item]!![text] as String,
                            text = stringResource(id = com.jbaloji.biblequiz.R.string.level_txt) + " " + (item + 1).toString() ,
                            action = {
                                navController.navigate(
                                    list[item]?.get(path) as String
                                )
                            },
                            enabled = list[item]?.get(enabled) as Int > 8
                        )

                    }
                }
            )

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

@Preview(name = "Levels Screen")
@Composable
fun Levels_Screen(){
    LevelsScreenContents(navController = rememberNavController( ), score = TimedQuizScore())
}