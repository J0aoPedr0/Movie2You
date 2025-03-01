package com.example.movie2you.presentation.screens.movies_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.design.themes.White
import com.example.movie2you.data.remote.dto.Result

@Composable
fun MoviesCategory(
    onMovieClick: () -> Unit,
    nowPlayingMovies: List<Result> = emptyList(),
    upComingMovies: List<Result>? = emptyList(),
    popularMovies: List<Result>? = emptyList(),
    topRatedMovies: List<Result>? = emptyList(),
) {
    LazyColumn {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "NowPlayingMovies",
                    color = White,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            LazyRow() {
                items(nowPlayingMovies) {
                    MoviePoster(
                        modifier = Modifier,
                        result = it,
                        onMovieClick = onMovieClick
                    )
                }
            }
        }
    }
}
/*LazyColumn(modifier = Modifier) {
    item {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "NowPlayingMovies",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        *//*LazyRow (){
                items(nowPlayingMovies){
                    MoviePoster(
                        result = it,
                        onMovieClick = onMovieClick
                        )
                }
            }*//*
            *//*

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){

                Text(text = "UpComingMovies",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold)
            }
            LazyRow (){
                items(upComingMovies){
                    MoviePoster(
                        result = it,
                        onMovieClick = onMovieClick
                    )
                }
            }
*//*

            *//*Row (modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){

                Text(text = "PopularMovies",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold)
            }
            LazyRow (){
                items(popularMovies){
                    MoviePoster(
                        result = it,
                        onMovieClick = onMovieClick
                    )
                }
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){

                Text(text = "Top Rated Movies",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold)
            }
            LazyRow (){
                items(topRatedMovies){
                    MoviePoster(
                        result = it,
                        onMovieClick = onMovieClick
                    )
                }
            }
        }*//*
        }

    }
}
*/