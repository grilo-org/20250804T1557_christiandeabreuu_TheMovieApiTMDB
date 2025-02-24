package com.example.desafiodimensa.domain.repository

import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.data.TMDbApiService

class MovieRepository(private val apiService: TMDbApiService) {

    suspend fun getSimilarMovies(movieId: Int, apiKey: String): List<Movie> {
        return apiService.getSimilarMovies(movieId, apiKey).results
    }
}