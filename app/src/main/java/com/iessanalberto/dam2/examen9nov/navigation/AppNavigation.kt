package com.iessanalberto.dam2.examen9nov.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iessanalberto.dam2.examen9nov.screens.LoginScreen
import com.iessanalberto.dam2.examen9nov.screens.SelectionScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route){
        composable(route = AppScreens.LoginScreen.route) { LoginScreen(navController)}
        composable(route = AppScreens.SelectionScreen.route) { SelectionScreen(navController)}
    }

}