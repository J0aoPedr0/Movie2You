package com.example.movie2you.data.mapper

import com.example.movie2you.data.remote.MovieResponse
import com.example.movie2you.domain.models.Movies
import com.example.movie2you.utils.GenreConstants

class MovieApiMapperImpl: ApiMapper<List<Movies>, MovieResponse> {

    override fun mapToDomain(apiDto: MovieResponse): List<Movies> {
        return apiDto.results   ?.map { result ->
            Movies(
                backdrop_path = formatEmptyValue(result?.backdropPath),
                genre_ids = formatGenre(result?.genreIds),
                id = result?.id ?: 0,
                original_language = formatEmptyValue(result?.originalLanguage, "language"),
                original_title = formatEmptyValue(result?.originalTitle, "title"),
                overview = formatEmptyValue(result?.overview, "overview"),
                popularity = result?.popularity ?: 0.0,
                poster_path = formatEmptyValue(result?.posterPath),
                release_date = formatEmptyValue(result?.releaseDate, "date"),
                title = formatEmptyValue(result?.title, "title"),
                video = result?.video ?: false,
                vote_average = result?.voteAverage ?: 0.0,
                vote_count = result?.voteCount ?: 0,
            )
        } ?: emptyList()
    }

    fun formatEmptyValue(value: String?, default: String = ""): String {
        if (value.isNullOrEmpty()){
            return "Unknown $default"
        }
        return value
    }
    fun formatGenre(genreIds: List<Int?>?): List<String> {
        return genreIds?.map { GenreConstants.getGenreNameById(it ?: 0)} ?: emptyList()
    }
}