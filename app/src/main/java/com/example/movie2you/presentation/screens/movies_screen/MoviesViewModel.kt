package com.example.movie2you.presentation.screens.movies_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movie2you.data.remote.dto.MovieResponse
import com.example.movie2you.data.repository.MoviesRepository
import com.example.movie2you.data.repository.MoviesRepositoryImpl
import com.example.movie2you.domain.use_case.GetMoviesUseCase
import com.example.movie2you.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel@Inject constructor(
    val getMoviesRepository: MoviesRepository
):ViewModel() {
    private val _moviesNowPlayingMovies = MutableStateFlow<MovieResponse?>(null)
    val moviesNowPlayingMovies = _moviesNowPlayingMovies.asStateFlow()

    private val _upComingMovies = MutableStateFlow<MovieResponse?>(null)
    val upComingMovies = _upComingMovies.asStateFlow()

    private val _popularMovies = MutableStateFlow<MovieResponse?>(null)
    val popularMovies = _popularMovies.asStateFlow()

    private val _topRatedMovies = MutableStateFlow<MovieResponse?>(null)
    val topRatedMovies = _topRatedMovies.asStateFlow()

    fun getMovies() {
        viewModelScope.launch {
            getMoviesRepository.GetNowPlayingMovies()
                .collect{
                when(it){
                    is Resource.Error -> {
                        println(it.message)
                    }
                    is Resource.Loading -> {
                        println("Loading")
                    }
                    is Resource.Success -> {
                        _moviesNowPlayingMovies.value = it.data
                    }
                }
            }
        }
        println("Deu certo")
    }
}