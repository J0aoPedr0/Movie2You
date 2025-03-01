package com.example.movie2you.domain.use_case

import com.example.movie2you.data.remote.dto.MovieResponse
import com.example.movie2you.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetMoviesUseCase {

    suspend fun GetNowPlayingMovies(): Flow<Resource<List<MovieResponse>>>
    suspend fun GetPopularMovies(): Flow<Resource<List<MovieResponse>>>
    suspend fun GetTopRatedMovies(): Flow<Resource<List<MovieResponse>>>
    suspend fun GetUpcomingMovies(): Flow<Resource<List<MovieResponse>>>

}