package com.jbaloji.biblequiz.navigation

object Screen {

    //-----------ID's
    const val Level_ID = "levelId"
    const val User_ID = "userId"
    const val Saved_Score_ID = "savedScore"
    const val Current_Score_ID = "currentScore"



    //-----------Routes
    const val Home = "home"
    const val Question = "questions/{$Level_ID}/{$Saved_Score_ID}"
    const val Score = "score/{$Level_ID}/{$Saved_Score_ID}/{$Current_Score_ID}"
    const val Levels = "levels"
    const val Auth ="auth"
    const val Lobby ="lobby"
//    const val Lobby ="lobby/{$User_ID}"
    const val PauseDialog = "pauseDialog"




    //----------Levels Screen constants
    private const val route = "questions/"
    const val Level_1 = route + "level_1"
    const val Level_2 = route + "level_2"
    const val Level_3 = route + "level_3"
    const val Level_4 = route + "level_4"
    const val Level_5 = route + "level_5"
    const val Level_6 = route + "level_6"
    const val Level_7 = route + "level_7"
    const val Level_8 = route + "level_8"
    const val Level_9 = route + "level_9"
    const val Level_10 = route + "level_10"
    const val Level_11 = route + "level_11"
    const val Level_12 = route + "level_12"
    const val Level_13 = route + "level_13"
    const val Level_14 = route + "level_14"
    const val Level_15 = route + "level_15"
    const val Level_16 = route + "level_16"
    const val Level_17 = route + "level_17"
    const val Level_18 = route + "level_18"
    const val Level_19 = route + "level_19"
    const val Level_20 = route + "level_20"

    //----------Home Screen Constant
    const val LobbyUser = "lobby/"

}