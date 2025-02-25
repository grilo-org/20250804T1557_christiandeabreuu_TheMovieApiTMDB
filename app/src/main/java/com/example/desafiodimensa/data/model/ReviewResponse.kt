package com.example.desafiodimensa.data.model

data class ReviewResponse(
    val id: Int,
    val page: Int,
    val results: List<Review>,
    val totalPages: Int,
    val totalResults: Int
)