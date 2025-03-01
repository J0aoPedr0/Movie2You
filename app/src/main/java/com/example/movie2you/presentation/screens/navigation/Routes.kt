package com.example.movie2you.presentation.screens.navigation

sealed class Routes(val route: String) {

    data object SplashScreen : Routes(route = "splash_screen")
    data object MoviesScreen : Routes(route = "movies_screen")
    data object DetailsScreen :Routes(route = "details_screen")
}