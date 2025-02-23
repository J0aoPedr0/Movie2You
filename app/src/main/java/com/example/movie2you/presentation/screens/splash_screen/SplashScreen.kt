package com.example.movie2you.presentation.screens.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movie2you.R
import com.example.movie2you.presentation.screens.navigation.Routes
import com.example.movie2you.presentation.theme.ui.theme.BackGroundColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000) // Tempo da splash screen
        navController.navigate(route = Routes.HomeScreen.route) // Navega para a tela principal
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(160.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen(navController = NavController(LocalContext.current))
}