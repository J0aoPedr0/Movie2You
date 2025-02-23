package com.example.movie2you.presentation.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movie2you.domain.models.Movies
import com.example.movie2you.domain.repository.MovieRepository
import com.example.movie2you.utils.collectAndHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MovieRepository
):ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()

    init {
        fetchNowPlayingMovies()
        fetchUpcomingMovies()
        fetchPopularMovies()
        fetchTopRatedMovies()
    }

    private fun fetchNowPlayingMovies() = viewModelScope.launch {
        repository.fetchNowPlayingMovies().collectAndHandle(
            onError = {
                _homeState.update {
                    it.copy(isLoading = false, error = it.error)
                }
            },
            onLoading = {
                _homeState.update {
                    it.copy(isLoading = true, error = null)
                }
            }
        ) { movies ->
            _homeState.update {
                it.copy(isLoading = false, error = null, NowPlayingMovies = movies)

        }
    }
}

    private fun fetchUpcomingMovies() = viewModelScope.launch {
        repository.fetchUpcomingMovies().collectAndHandle(
            onError = {
                _homeState.update {
                    it.copy(isLoading = false, error = it.error)
                }
            },
            onLoading = {
                _homeState.update {
                    it.copy(isLoading = true, error = null)
                }
            }
        ) { movies ->
            _homeState.update {
                it.copy(isLoading = false, error = null, UpcomingMovies = movies)

        }
    }
}

    private fun fetchPopularMovies() = viewModelScope.launch {
        repository.fetchPopularMovies().collectAndHandle(
            onError = {
                _homeState.update {
                    it.copy(isLoading = false, error = it.error)
                }
            },
            onLoading = {
                _homeState.update {
                    it.copy(isLoading = true, error = null)
                }
            }
        ) { movies ->
            _homeState.update {
                it.copy(isLoading = false, error = null, PopularMovies = movies)

        }
    }
}

    private fun fetchTopRatedMovies() = viewModelScope.launch {
        repository.fetchTopRatedMovies().collectAndHandle(
            onError = {
                _homeState.update {
                    it.copy(isLoading = false, error = it.error)
                }
            },
            onLoading = {
                _homeState.update {
                    it.copy(isLoading = true, error = null)
                }
            }
        ) { movies ->
            _homeState.update {
                it.copy(isLoading = false, error = null, TopRatedMovies = movies)

        }
    }
}




data class HomeState(
    val NowPlayingMovies:List<Movies> = emptyList(),
    val UpcomingMovies:List<Movies> = emptyList(),
    val PopularMovies:List<Movies> = emptyList(),
    val TopRatedMovies:List<Movies> = emptyList(),
    val error: String? = null,
    val isLoading:Boolean = false)
}