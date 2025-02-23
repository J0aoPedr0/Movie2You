
package com.example.movie2you.data.remote

data class MovieResponse(
    val page: Int? = null,
    val results: List<Result?>? = null,
    val totalPages: Int? = null,
    val totalResults: Int? = null
)
