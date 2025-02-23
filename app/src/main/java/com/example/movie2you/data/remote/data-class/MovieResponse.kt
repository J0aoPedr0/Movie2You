
package com.example.movie2you.data.remote

import com.example.movie2you.domain.models.Movies

data class MovieResponse(
    val page: Int? = null,
    val results: List<Movies?>? = null,
    val totalPages: Int? = null,
    val totalResults: Int? = null
)
