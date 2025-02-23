package com.example.movie2you.domain.repository

import com.example.movie2you.domain.models.Movies
import kotlinx.coroutines.flow.Flow
import com.example.movie2you.utils.Response

interface MovieRepository {
    fun fetchNowPlayingMovies(): Flow<Response<List<Movies>>>
    fun fetchUpcomingMovies(): Flow<Response<List<Movies>>>
    fun fetchPopularMovies(): Flow<Response<List<Movies>>>
    fun fetchTopRatedMovies(): Flow<Response<List<Movies>>>
}