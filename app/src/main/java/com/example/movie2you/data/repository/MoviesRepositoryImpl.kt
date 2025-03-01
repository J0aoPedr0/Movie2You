package com.example.movie2you.data.repository

import coil3.network.HttpException
import com.example.movie2you.data.remote.MoviesApi
import com.example.movie2you.data.remote.dto.MovieResponse
import com.example.movie2you.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi
):MoviesRepository {

    override suspend fun GetNowPlayingMovies(): Flow<Resource<MovieResponse>> = flow {
        try {
            emit(Resource.Loading())
            val movies = moviesApi.GetNowPlayingMovies()
            emit(Resource.Success(movies))
        }catch (e:Exception){
            emit(Resource.Error("An unexpected error occurred:${e.localizedMessage}"))
        }catch (e:HttpException){
            emit(Resource.Error("An unexpected error occurred:${e.localizedMessage}"))
        }catch (e:IOException){
            emit(Resource.Error("An unexpected error occurred, please check your internet connection:${e.localizedMessage}"))
        }
    }

    override suspend fun GetUpcomingMovies(): Flow<Resource<List<MovieResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = moviesApi.GetUpcomingMovies()
            emit(Resource.Success(movies))
        }catch (e:Exception){
            emit(Resource.Error("An unexpected error occurred:${e.localizedMessage}"))
        }catch (e:HttpException){
            emit(Resource.Error("An unexpected error occurred:${e.localizedMessage}"))
        }catch (e:IOException){
            emit(Resource.Error("An unexpected error occurred, please check your internet connection:${e.localizedMessage}"))
        }
    }

    override suspend fun GetPopularMovies(): Flow<Resource<List<MovieResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = moviesApi.GetPopularMovies()
            emit(Resource.Success(movies))
        }catch (e:Exception){
            emit(Resource.Error("An unexpected error occurred:${e.localizedMessage}"))
        }catch (e:HttpException){
            emit(Resource.Error("An unexpected error occurred:${e.localizedMessage}"))
        }catch (e:IOException){
            emit(Resource.Error("An unexpected error occurred, please check your internet connection:${e.localizedMessage}"))
        }
    }

    override suspend fun GetTopRatedMovies(): Flow<Resource<List<MovieResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = moviesApi.GetTopRatedMovies()
            emit(Resource.Success(movies))
        }catch (e:Exception){
            emit(Resource.Error("An unexpected error occurred:${e.localizedMessage}"))
        }catch (e:HttpException){
            emit(Resource.Error("An unexpected error occurred:${e.localizedMessage}"))
        }catch (e:IOException){
            emit(Resource.Error("An unexpected error occurred, please check your internet connection:${e.localizedMessage}"))
        }
    }
}