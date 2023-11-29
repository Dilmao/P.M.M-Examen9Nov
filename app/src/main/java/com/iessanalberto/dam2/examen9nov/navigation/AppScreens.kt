package com.iessanalberto.dam2.examen9nov.navigation

sealed class AppScreens (val route: String) {
    object LoginScreen: AppScreens (route = "login_screen")
    object SelectionScreen: AppScreens (route = "selection_screen")
}
