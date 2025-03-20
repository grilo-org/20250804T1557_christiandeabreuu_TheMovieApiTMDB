package com.example.desafiodimensa.domain.repository

import com.example.desafiodimensa.data.model.DetailsMovie
import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.data.remote.TMDbApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val apiService: TMDbApiService) {

    suspend fun getSimilarMovies(movieId: Int,): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getSimilarMovies(movieId)
            response.results
        }
    }

    suspend fun getNowPlayingMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getNowPlayingMovies()
            response.results
        }
    }

    suspend fun getComingSoonMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getComingSoonMovies()
            response.results
        }
    }

    suspend fun getMorePopularMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getMorePopularMovies()
            response.results
        }
    }

    suspend fun getTopRatedMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getTopRatedMovies()
            response.results
        }
    }

    suspend fun getDetailsMovie(movieId: Int): DetailsMovie {
        return withContext(Dispatchers.IO) {
            apiService.getMovieDetail(movieId)
        }
    }
}