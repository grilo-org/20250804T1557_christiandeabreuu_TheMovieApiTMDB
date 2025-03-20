package com.example.desafiodimensa.domain.usecase

import com.example.desafiodimensa.data.model.DetailsMovie
import com.example.desafiodimensa.domain.repository.MovieRepository

class GetDetailsMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): DetailsMovie {
        return repository.getDetailsMovie(movieId)
    }
}