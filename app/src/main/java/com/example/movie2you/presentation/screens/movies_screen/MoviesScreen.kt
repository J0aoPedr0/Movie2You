package com.example.movie2you.presentation.screens.movies_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.design.themes.BackGroundColor
import com.example.movie2you.R
import com.example.movie2you.presentation.screens.movies_screen.components.MoviesCategory

@Composable
fun MoviesScreen(
    viewModel: MoviesViewModel = hiltViewModel(),
    onMovieClick: () -> Unit = {},
) {
    val moviesNowPlaying by viewModel.moviesNowPlayingMovies.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getMovies()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGroundColor)
            .padding(top = 60.dp)
    ) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Image(
                painterResource(id = R.drawable.ic_logo),
                contentDescription = "Logo image",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
            )
        }
         MoviesCategory(
             onMovieClick = onMovieClick,
                    nowPlayingMovies = moviesNowPlaying?.results ?: emptyList(),
                    upComingMovies = emptyList(),
                    popularMovies = emptyList(),
                    topRatedMovies = emptyList()
                    )

    }
}

@Preview(showBackground = true)
@Composable
private fun MoviesScreenPreview() {
    MoviesScreen()
}