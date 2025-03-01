package com.example.movie2you.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movie2you.presentation.screens.details_screen.DetailsScreen
import com.example.movie2you.presentation.screens.movies_screen.MoviesScreen
import com.example.movie2you.presentation.screens.splash_screen.SplashScreen

@Composable
fun AppScreenNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route)
    {
        composable(route = Routes.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(route = Routes.MoviesScreen.route){
            MoviesScreen(
                onMovieClick = { navController.navigate(Routes.DetailsScreen.route) }
            )
        }
        composable(route = Routes.DetailsScreen.route){
            DetailsScreen()
        }
    }
}