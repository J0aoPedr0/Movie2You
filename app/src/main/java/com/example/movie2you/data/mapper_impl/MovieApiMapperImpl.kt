package com.example.movie2you.data.mapper_impl

import com.example.movie2you.common.data.ApiMapper
import com.example.movie2you.data.retrofit.MovieResponse
import com.example.movie2you.domain.models.Movies
import com.example.movie2you.utils.GenreConstants

class MovieApiMapperImpl:ApiMapper<List<Movies>,MovieResponse> {

    override fun mapToDomain(apiDto: MovieResponse): List<Movies> {

    }

    fun formatEmptyValue(value: String?, default: String = ""): String {
        if (value.isNullOrEmpty()){
            return "Unknown $default"
        }
    }
    fun formatGenre(genreIds: List<Int?>?): List<String> {
        return genreIds?.map { GenreConstants.getGenreNameById(it ?: 0)} ?: emptyList()
    }
}