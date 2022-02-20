package com.julenrob.retodefinitivo.ui.theme.Navigation

sealed class AppScreens(val route: String){
    object FirstScreen: AppScreens("first_screen")
    object SecondScreen: AppScreens("second_screen")
}
