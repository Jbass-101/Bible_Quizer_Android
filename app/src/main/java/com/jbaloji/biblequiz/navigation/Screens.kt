package com.jbaloji.biblequiz.navigation

sealed class Screens(val route:String){

    object Home: Screens(route = "home_screen")
    object Questions: Screens(route = "questions_screen")

}
