package com.example.movie2you.domain.use_case

import com.example.movie2you.data.remote.dto.MovieResponse
import com.example.movie2you.data.repository.MoviesRepository
import com.example.movie2you.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesUseCaseImpl @Inject constructor(
    private val repository: MoviesRepository
):GetMoviesUseCase {

    override suspend fun GetNowPlayingMovies() : Flow<Resource<List<MovieResponse>>> = flow  {
        repository.GetNowPlayingMovies()
    }
    override suspend fun GetUpcomingMovies() : Flow<Resource<List<MovieResponse>>> {
        return repository.GetUpcomingMovies()
    }
    override suspend fun GetPopularMovies() : Flow<Resource<List<MovieResponse>>> {
        return repository.GetPopularMovies()
    }
    override suspend fun GetTopRatedMovies() : Flow<Resource<List<MovieResponse>>> {
        return repository.GetTopRatedMovies()
    }
}