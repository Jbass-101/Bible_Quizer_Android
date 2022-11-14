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
    const val Lobby ="lobby/{$User_ID}"
    const val PauseDialog = "pauseDialog"




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