package com.example.movie2you.data.remote.dto

data class MovieResponse(
    val page: Int? = null,
    val results: List<Result>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)