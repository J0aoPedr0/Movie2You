package com.example.movie2you.presentation.screens.navigation

sealed class Routes(val route: String) {


    data object SplashScreen : Routes(route = "splash_screen")
    data object HomeScreen : Routes(route = "home_screen")
}