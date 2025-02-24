package com.example.desafiodimensa.domain.repository

import com.example.desafiodimensa.data.Review
import com.example.desafiodimensa.data.TMDbApiService

class ReviewRepository(private val apiService: TMDbApiService) {

    suspend fun getReviews(movieId: Int, apiKey: String): List<Review> {
        return apiService.getReviews(movieId, apiKey).reviewResults
    }

}