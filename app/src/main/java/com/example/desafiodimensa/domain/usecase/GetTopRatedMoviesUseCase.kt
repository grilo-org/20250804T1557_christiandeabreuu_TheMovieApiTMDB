package com.example.desafiodimensa.domain.usecase

import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.domain.repository.MovieRepository

class GetTopRatedMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> {
        return repository.getTopRatedMovies()
    }
}