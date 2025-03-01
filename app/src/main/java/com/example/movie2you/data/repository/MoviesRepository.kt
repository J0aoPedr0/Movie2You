package com.example.movie2you.data.repository

import com.example.movie2you.data.remote.dto.MovieResponse
import com.example.movie2you.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun GetNowPlayingMovies(): Flow<Resource<MovieResponse>>
    suspend fun GetUpcomingMovies(): Flow<Resource<List<MovieResponse>>>
    suspend fun GetPopularMovies(): Flow<Resource<List<MovieResponse>>>
    suspend fun GetTopRatedMovies(): Flow<Resource<List<MovieResponse>>>

}