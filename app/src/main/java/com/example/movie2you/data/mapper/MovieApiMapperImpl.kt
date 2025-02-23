package com.example.movie2you.data.mapper

import com.example.movie2you.data.remote.MovieResponse
import com.example.movie2you.domain.models.Movies
import com.example.movie2you.utils.GenreConstants

class MovieApiMapperImpl: ApiMapper<List<Movies>, MovieResponse> {

    override fun mapToDomain(apiDto: MovieResponse): List<Movies> {
        return apiDto.results   ?.map { result ->
            Movies(
                backdrop_path = formatEmptyValue(result?.backdrop_path),
                genreIds = formatGenre(result?.genreIds),
                id = result?.id ?: 0,
                original_language = formatEmptyValue(result?.original_language, "language"),
                original_title = formatEmptyValue(result?.original_title, "title"),
                overview = formatEmptyValue(result?.overview, "overview"),
                popularity = result?.popularity ?: 0.0,
                poster_path = formatEmptyValue(result?.poster_path),
                release_date = formatEmptyValue(result?.release_date, "date"),
                title = formatEmptyValue(result?.title, "title"),
                video = result?.video ?: false,
                vote_average = result?.vote_average ?: 0.0,
                vote_count = result?.vote_count ?: 0,
            )
        } ?: emptyList()
    }

    fun formatEmptyValue(value: String?, default: String = ""): String {
        if (value.isNullOrEmpty()){
            return "Unknown $default"
        }
        return value
    }
    fun formatGenre(genreIds: List<String?>?): List<String> {
        return genreIds?.map { GenreConstants.getGenreNameById(it ?: 0)} ?: emptyList()
    }
}