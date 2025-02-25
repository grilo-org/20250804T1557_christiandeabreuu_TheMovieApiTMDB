package com.example.desafiodimensa.domain.repository

import com.example.desafiodimensa.data.model.DetailsMovie
import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.data.remote.TMDbApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val apiService: TMDbApiService) {

    suspend fun getSimilarMovies(movieId: Int, apiKey: String): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getSimilarMovies(movieId, apiKey)
            response.results
        }
    }

    suspend fun getNowPlayingMovies(apiKey: String): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getNowPlayingMovies(apiKey)
            response.results
        }
    }

    suspend fun getComingSoonMovies(apiKey: String): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getComingSoonMovies(apiKey)
            response.results
        }
    }

    suspend fun getMorePopularMovies(apiKey: String): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getMorePopularMovies(apiKey)
            response.results
        }
    }

    suspend fun getTopRatedMovies(apiKey: String): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getTopRatedMovies(apiKey)
            response.results
        }
    }

    suspend fun getDetailsMovie(movieId: Int, apiKey: String): DetailsMovie {
        return withContext(Dispatchers.IO) {
            apiService.getMovieDetail(movieId, apiKey)
        }
    }
}