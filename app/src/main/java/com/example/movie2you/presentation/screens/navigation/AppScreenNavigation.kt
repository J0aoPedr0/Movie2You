package com.example.movie2you.presentation.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movie2you.presentation.screens.home_screen.HomeScreen
import com.example.movie2you.presentation.screens.splash_screen.SplashScreen

@Composable
fun AppScreenNavigation() {
val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route)
    {
        composable(route = Routes.HomeScreen.route){
            HomeScreen()
        }
        composable(route = Routes.SplashScreen.route){
            SplashScreen(navController = navController)
        }
    }
}