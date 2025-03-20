package com.example.desafiodimensa.domain.usecase

import com.example.desafiodimensa.data.model.Review
import com.example.desafiodimensa.domain.repository.ReviewRepository

class GetReviewsUseCase(private val repository: ReviewRepository) {
    suspend operator fun invoke(movieId: Int): List<Review> {
        return repository.getReviews(movieId)
    }
}