package com.example.desafiodimensa.domain.repository

import com.example.desafiodimensa.data.model.Review
import com.example.desafiodimensa.data.remote.TMDbApiService

class ReviewRepository(private val apiService: TMDbApiService) {

    suspend fun getReviews(movieId: Int): List<Review> {
        return apiService.getReviews(movieId).results
    }
}