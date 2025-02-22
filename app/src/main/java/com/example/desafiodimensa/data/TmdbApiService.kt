package com.example.desafiodimensa.data

import retrofit2.http.GET
import retrofit2.http.Query

interface TMDbApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int = 1
    ): MovieResponse
}