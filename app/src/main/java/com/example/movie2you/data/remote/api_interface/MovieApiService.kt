package com.example.movie2you.data.remote.api_interface

import com.example.movie2you.BuildConfig
import com.example.movie2you.data.remote.MovieResponse
import com.example.movie2you.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET(Constants.NOW_PLAYING_ENDPOINT)
    suspend fun fetchNowPlayingMovies(
        @Query("api_key")apiKey:String = Constants.API_KEY
    ):MovieResponse

    @GET(Constants.UPCOMING_ENDPOINT)
    suspend fun fetchUpcomingMovies(
        @Query("api_key")apiKey:String = Constants.API_KEY
    ):MovieResponse

    @GET(Constants.POPULAR_ENDPOINT)
    suspend fun fetchPopularMovies(
        @Query("api_key")apiKey:String = Constants.API_KEY
    ):MovieResponse

    @GET(Constants.TOP_RATED_ENDPOINT)
    suspend fun fetchTopRatedMovies(
        @Query("api_key")apiKey:String = Constants.API_KEY
    ):MovieResponse
}