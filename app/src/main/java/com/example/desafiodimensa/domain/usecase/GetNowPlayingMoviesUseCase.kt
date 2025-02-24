package com.example.desafiodimensa.domain.usecase

import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.domain.repository.MovieRepository

class GetNowPlayingMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(apiKey: String): List<Movie> {
        return repository.getNowPlayingMovies( apiKey)
    }
}