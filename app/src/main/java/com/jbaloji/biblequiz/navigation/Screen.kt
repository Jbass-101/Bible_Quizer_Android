package com.jbaloji.biblequiz.navigation

object Screen {
    const val Home = "home"
    const val Question = "questions/{levelId}"
    const val Score = "score/{levelId}/{scoreId}"
    const val Levels = "levels"
    const val Auth ="auth"
    const val Lobby ="lobby/{userId}"
    const val PauseDialog = "pauseDialog"


    //-----------Screen ID's
    const val Level_ID = "levelId"
    const val User_ID = "userId"
    const val Score_ID = "scoreId"


    //----------Levels Screen constants
    private const val route = "questions/"
    const val Level_1 = route + "level_1"
    const val Level_2 = route + "level_2"
    const val Level_3 = route + "level_3"
    const val Level_4 = route + "level_4"
    const val Level_5 = route + "level_5"

    //----------Home Screen Constant
    const val LobbyUser = "lobby/"

}