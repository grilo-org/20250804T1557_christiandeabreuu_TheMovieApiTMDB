package com.example.desafiodimensa.domain.usecase

import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.domain.repository.MovieRepository

class GetSimilarMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): List<Movie> {
        return repository.getSimilarMovies(movieId)
    }
}