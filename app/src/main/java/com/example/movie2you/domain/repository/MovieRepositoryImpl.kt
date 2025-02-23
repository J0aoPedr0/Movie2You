package com.example.movie2you.domain.repository

import com.example.movie2you.data.mapper.ApiMapper
import com.example.movie2you.data.remote.MovieResponse
import com.example.movie2you.data.remote.api_interface.MovieApiService
import com.example.movie2you.domain.models.Movies
import com.example.movie2you.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    val movieApiService: MovieApiService,
    val apiMapper: ApiMapper<List<Movies>, MovieResponse>
):MovieRepository
{
    override fun fetchNowPlayingMovies(): Flow<Response<List<Movies>>> = flow {
        emit(Response.Loading())
        val movieResponse = movieApiService.fetchNowPlayingMovies()
        apiMapper.mapToDomain(movieResponse).apply {
            emit(Response.Success(this))
        }
    }.catch {e ->
        emit(Response.Failure(e))
    }

    override fun fetchUpcomingMovies(): Flow<Response<List<Movies>>> = flow {
        emit(Response.Loading())
        val movieResponse = movieApiService.fetchUpcomingMovies()
        apiMapper.mapToDomain(movieResponse).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        emit(Response.Failure(e))
    }

    override fun fetchPopularMovies(): Flow<Response<List<Movies>>> = flow {
        emit(Response.Loading())
        val movieResponse = movieApiService.fetchPopularMovies()
        apiMapper.mapToDomain(movieResponse).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        emit(Response.Failure(e))
    }

    override fun fetchTopRatedMovies(): Flow<Response<List<Movies>>> = flow {
        emit(Response.Loading())
        val movieResponse = movieApiService.fetchTopRatedMovies()
        apiMapper.mapToDomain(movieResponse).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        emit(Response.Failure(e))
    }

}