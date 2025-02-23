package com.example.movie2you.domain.models

data class Movies(
    val backdrop_path: String,
    val genreIds: List<String?>? = null,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)