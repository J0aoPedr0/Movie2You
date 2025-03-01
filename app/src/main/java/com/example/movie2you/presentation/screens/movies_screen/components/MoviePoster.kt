package com.example.movie2you.presentation.screens.movies_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.movie2you.data.remote.dto.Result
import com.example.movie2you.utils.Constants

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    result: Result,
    onMovieClick: () -> Unit, )
{
    val posterRequest = ImageRequest.Builder(LocalContext.current)
        .data("${Constants.BASE_IMAGE_URL}${result.poster_path}")
        .crossfade(enable = true)
        .build()
    Box(modifier = modifier
        .size(
            width = 150.dp,
            height = 220.dp)
        .padding(4.dp)
        .border(2.dp, Color.White, RoundedCornerShape(8.dp))
        .clickable { result.id?.let { onMovieClick() } }
    ) {
        AsyncImage(
            model = posterRequest,
            contentDescription = null,
            modifier = modifier
                .matchParentSize()
                .clip(MaterialTheme.shapes.medium)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        modifier = Modifier,
        result = Result(),
        onMovieClick = {})}