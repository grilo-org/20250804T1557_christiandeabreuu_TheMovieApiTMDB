package com.example.desafiodimensa.data

data class ReviewResponse(
    val id: Int,
    val page: Int,
    val reviewResults: List<Review>,
    val total_pages: Int,
    val total_results: Int
)