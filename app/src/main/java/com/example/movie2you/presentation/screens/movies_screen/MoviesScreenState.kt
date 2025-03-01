package com.example.movie2you.presentation.screens.movies_screen

import com.example.movie2you.data.remote.dto.MovieResponse

data class MoviesScreenState(
    val isLoading: Boolean = false,
    val movies: List<MovieResponse> = emptyList(),
    val error: String? = null
)
