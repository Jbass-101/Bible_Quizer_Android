package com.jbaloji.biblequiz.presentation.levels

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.navigation.Screen.Level_1
import com.jbaloji.biblequiz.navigation.Screen.Level_2
import com.jbaloji.biblequiz.navigation.Screen.Level_3
import com.jbaloji.biblequiz.navigation.Screen.Level_4
import com.jbaloji.biblequiz.navigation.Screen.Level_5
import com.jbaloji.biblequiz.navigation.Screen.Level_6
import com.jbaloji.biblequiz.navigation.Screen.Level_7
import com.jbaloji.biblequiz.navigation.Screen.Level_8
import com.jbaloji.biblequiz.navigation.Screen.Level_9
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
import com.jbaloji.biblequiz.navigation.Screen.Level_20
import com.jbaloji.biblequiz.presentation.home.components.GenericButton

@Composable
fun LevelsScreen(
    navController: NavController,
    viewModel: LevelsViewModel = hiltViewModel()
){
    val text = "text"
    val path = "path"
    val enabled = "enabled"

    val list = mapOf(
        0 to mapOf(
            text to "Level 1",
            path to Level_1 +"/"+viewModel.score1,
            enabled to 15
        ),
        1 to mapOf(
            text to "Level 2",
            path to Level_2 +"/"+viewModel.score2,
            enabled to viewModel.score1
        ),
        2 to mapOf(
            text to "Level 3",
            path to Level_3 +"/"+viewModel.score3,
            enabled to viewModel.score2
        ),
        3 to mapOf(
            text to "Level 4",
            path to Level_4 +"/"+viewModel.score4,
            enabled to viewModel.score3
        ),
        4 to mapOf(
            text to "Level 5",
            path to Level_5 +"/"+viewModel.score5,
            enabled to viewModel.score4
        ),
        5 to mapOf(
            text to "Level 6",
            path to Level_6 +"/"+viewModel.score6,
            enabled to viewModel.score5
        ),
        6 to mapOf(
            text to "Level 7",
            path to Level_7 +"/"+viewModel.score7,
            enabled to viewModel.score6
        ),
        7 to mapOf(
            text to "Level 8",
            path to Level_8 +"/"+viewModel.score8,
            enabled to viewModel.score7
        ),
        8 to mapOf(
            text to "Level 9",
            path to Level_9 +"/"+viewModel.score9,
            enabled to viewModel.score8
        ),
        9 to mapOf(
            text to "Level 10",
            path to Level_10 +"/"+viewModel.score10,
            enabled to viewModel.score9
        ),
        10 to mapOf(
            text to "Level 11",
            path to Level_11 +"/"+viewModel.score11,
            enabled to viewModel.score10
        ),
        11 to mapOf(
            text to "Level 12",
            path to Level_12 +"/"+viewModel.score12,
            enabled to viewModel.score11
        ),
        12 to mapOf(
            text to "Level 13",
            path to Level_13 +"/"+viewModel.score13,
            enabled to viewModel.score12
        ),
        13 to mapOf(
            text to "Level 14",
            path to Level_14 +"/"+viewModel.score14,
            enabled to viewModel.score13
        ),
        14 to mapOf(
            text to "Level 15",
            path to Level_15 +"/"+viewModel.score15,
            enabled to viewModel.score14
        ),
        15 to mapOf(
            text to "Level 16",
            path to Level_16 +"/"+viewModel.score16,
            enabled to viewModel.score15
        ),
        16 to mapOf(
            text to "Level 17",
            path to Level_17 +"/"+viewModel.score17,
            enabled to viewModel.score16
        ),
        17 to mapOf(
            text to "Level 18",
            path to Level_18 +"/"+viewModel.score18,
            enabled to viewModel.score17
        ),
        18 to mapOf(
            text to "Level 19",
            path to Level_19 +"/"+viewModel.score19,
            enabled to viewModel.score18
        ),
        19 to mapOf(
            text to "Level 20",
            path to Level_20 +"/"+viewModel.score20,
            enabled to viewModel.score19
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(1f)
    ) {

        Text(
            text = "Select Level",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            userScrollEnabled = true,
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(1f),
            content = {
                items(list.size){ item ->
                    GenericButton(
                        text = list[item]!![text] as String,
                        action = { navController.navigate(
                            list[item]?.get(path) as String
                        ) },
                        enabled = list[item]?.get(enabled) as Int > 8
                    )

                }
            }
        )
        Spacer(modifier = Modifier.height(8.dp))
        GenericButton(
            text = "Back" ,
            action = { navController.navigateUp() }
        )
    }


    when(val response = viewModel.userDataResponse){
        is Response.Success -> {
            viewModel.score1 = response.data.level_1
            viewModel.score2 = response.data.level_2
            viewModel.score3 = response.data.level_3
            viewModel.score4 = response.data.level_4
            viewModel.score5 = response.data.level_5
            viewModel.score6 = response.data.level_6
            viewModel.score7 = response.data.level_7
            viewModel.score8 = response.data.level_8
            viewModel.score9 = response.data.level_9
            viewModel.score10 = response.data.level_10
            viewModel.score11 = response.data.level_11
            viewModel.score12 = response.data.level_12
            viewModel.score13 = response.data.level_13
            viewModel.score14 = response.data.level_14
            viewModel.score15 = response.data.level_15
            viewModel.score16 = response.data.level_16
            viewModel.score17 = response.data.level_17
            viewModel.score18 = response.data.level_18
            viewModel.score19 = response.data.level_19
            viewModel.score20 = response.data.level_20
        }
        else -> {}
    }





}