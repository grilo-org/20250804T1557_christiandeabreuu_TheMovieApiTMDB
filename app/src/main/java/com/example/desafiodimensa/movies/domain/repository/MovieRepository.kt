package com.example.desafiodimensa.movies.domain.repository

import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.data.TMDbApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepositoryy(private val apiService: TMDbApiService) {
    suspend fun getComingSoonMovies(apiKey: String): List<Movie> {
        return apiService.getComingSoonMovies(apiKey).results
    }

    suspend fun getMostPopularMovies(apiKey: String): List<Movie> {
        return apiService.getMorePopularMovies(apiKey).results
    }

    suspend fun getNowPlayingMovies(apiKey: String): List<Movie> {
        return apiService.getNowPlayingMovies(apiKey).results
    }

    suspend fun getTopRatedMovies(apiKey: String): List<Movie> {
        return apiService.getTopRatedMovies(apiKey).results
    }

}