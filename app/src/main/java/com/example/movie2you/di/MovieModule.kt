package com.example.movie2you.di

import retrofit2.converter.gson.GsonConverterFactory
import com.example.movie2you.data.mapper.ApiMapper
import com.example.movie2you.data.mapper.MovieApiMapperImpl
import com.example.movie2you.data.remote.MovieResponse
import com.example.movie2you.data.remote.api_interface.MovieApiService
import com.example.movie2you.domain.models.Movies
import com.example.movie2you.domain.repository.MovieRepository
import com.example.movie2you.domain.repository.MovieRepositoryImpl
import com.example.movie2you.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {
    @Provides
    @Singleton
    fun providerMovieRepository(
        movieApiRepository: MovieApiService,
        mapper: ApiMapper<List<Movies>, MovieResponse>
    ):MovieRepository = MovieRepositoryImpl(
        movieApiService = movieApiRepository,
        apiMapper = mapper
    )

    @Provides
    @Singleton
    fun providerMovieMapper(): ApiMapper<List<Movies>, MovieResponse> = MovieApiMapperImpl()

    @Provides
    @Singleton
    fun providerMovieApiService(): MovieApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApiService::class.java)
    }
}