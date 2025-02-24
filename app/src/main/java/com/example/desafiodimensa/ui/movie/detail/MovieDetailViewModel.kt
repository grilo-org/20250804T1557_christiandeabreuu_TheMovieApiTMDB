package com.example.desafiodimensa.ui.movie.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiodimensa.RetrofitClient
import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.data.Review
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel() {

    private val _similarMovies = MutableLiveData<List<Movie>>()
    val similarMovies: LiveData<List<Movie>> get() = _similarMovies

    private val _reviewsComments = MutableLiveData<List<Review>?>()
    val reviewsComments: LiveData<List<Review>?> get() = _reviewsComments

    fun getReviews(id:Int,apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getReviews(movieId = id, apiKey = "13296e8a57292f8440cd14c19aa739ec")
                _reviewsComments.value = response.reviewResults
                Log.d("MovieDetailViewModel", "Reviews: ${response.reviewResults}")
            } catch (e: Exception) {
                Log.e("MovieDetailViewModel", "Erro ao buscar comentários: ${e.message}")
            }
        }
    }

    fun getSimularMovies(id:Int,apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getSimilarMovies(movieId = id, apiKey = "13296e8a57292f8440cd14c19aa739ec")
                _similarMovies.value = response.results
            } catch (e: Exception) {
                Log.e("MovieDetailViewModel", "Erro ao buscar filmes relacionados: ${e.message}")
            }
        }
    }
}