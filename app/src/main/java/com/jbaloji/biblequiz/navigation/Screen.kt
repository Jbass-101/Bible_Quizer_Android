package com.jbaloji.biblequiz.navigation

object Screen {
    const val Home = "home"
    const val Question = "questions/{levelId}"
    const val Score = "score"
    const val Levels = "levels"
    const val Auth ="auth"
    const val Lobby ="lobby/{userId}"
    const val PauseDialog = "pauseDialog"


    //-----------Screen ID's
    //-> Questions Screen
    const val Level_ID = "levelId"
    const val User_ID = "userId"


    //----------Levels Screen constants
    private const val route = "questions/"
    const val Level_1 = route + "Level_1"
    const val Level_2 = route + "Level_2"
    const val Level_3 = route + "Level_3"
    const val Level_4 = route + "Level_4"
    const val Level_5 = route + "Level_5"

    //----------Home Screen Constant
    const val LobbyUser = "lobby/"

}