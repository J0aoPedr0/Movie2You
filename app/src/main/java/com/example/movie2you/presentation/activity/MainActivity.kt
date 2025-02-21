package com.example.movie2you.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.movie2you.presentation.screens.navigation.AppScreenNavigation
import com.example.movie2you.presentation.theme.ui.theme.Movie2YouTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Movie2YouTheme {
                AppScreenNavigation()
            }
        }
    }
}

