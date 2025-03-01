package com.example.movie2you.data.remote

import com.example.movie2you.data.remote.dto.MovieResponse
import com.example.movie2you.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
        @GET(Constants.NOW_PLAYING_ENDPOINT)
        suspend fun GetNowPlayingMovies(
            @Query("api_key") apiKey:String = Constants.API_KEY,
            @Query("language") language:String = "pt-BR",
        ):MovieResponse

        @GET(Constants.UPCOMING_ENDPOINT)
        suspend fun GetUpcomingMovies(
            @Query("api_key")apiKey:String = Constants.API_KEY,
            @Query("language")language:String = "pt-BR"
        ): List<MovieResponse>

        @GET(Constants.POPULAR_ENDPOINT)
        suspend fun GetPopularMovies(
            @Query("api_key")apiKey:String = Constants.API_KEY,
            @Query("language")language:String = "pt-BR"
        ): List<MovieResponse>

        @GET(Constants.TOP_RATED_ENDPOINT)
        suspend fun GetTopRatedMovies(
            @Query("api_key")apiKey:String = Constants.API_KEY,
            @Query("language")language:String = "pt-BR"
        ): List<MovieResponse>
}