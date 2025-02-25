package com.example.desafiodimensa.data.model

data class ReviewResponse(
    val id: Int,
    val page: Int,
    val reviewResults: List<Review>,
    val totalPages: Int,
    val totalResults: Int
)