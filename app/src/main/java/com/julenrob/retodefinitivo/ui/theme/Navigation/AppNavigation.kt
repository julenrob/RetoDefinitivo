package com.julenrob.retodefinitivo.ui.theme.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.julenrob.retodefinitivo.ui.theme.Screens.FirstScreen
import com.julenrob.retodefinitivo.ui.theme.Screens.SecondScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route + "/{title}" + "/{description}" + "/{image}",
            arguments = listOf(navArgument(name="title"){
                type = NavType.IntType
            })) {
            it.arguments?.let { it1 -> SecondScreen(navController, it.arguments?.getString("title"), it.arguments?.getString("description"), it.arguments!!.getInt("image")) }
        }
    }
}