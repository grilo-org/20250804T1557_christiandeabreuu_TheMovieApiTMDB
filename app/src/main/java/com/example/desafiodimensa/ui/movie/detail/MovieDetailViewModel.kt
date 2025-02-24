package com.example.desafiodimensa.ui.movie.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiodimensa.util.Constants
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.remote.RetrofitClient
import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.data.model.Review
import com.example.desafiodimensa.domain.usecase.GetReviewsUseCase
import com.example.desafiodimensa.domain.usecase.GetSimilarMoviesUseCase
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getReviewsUseCase: GetReviewsUseCase,
    private val getSimilarMoviesUseCase: GetSimilarMoviesUseCase
) : ViewModel() {

    private val _similarMovies = MutableLiveData<List<Movie>>()
    val similarMovies: LiveData<List<Movie>> get() = _similarMovies

    private val _reviewsComments = MutableLiveData<List<Review>?>()
    val reviewsComments: LiveData<List<Review>?> get() = _reviewsComments

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getReviews(id: Int, apiKey: String) {
        viewModelScope.launch {
            try {
                _reviewsComments.value = getReviewsUseCase(id,apiKey)

            } catch (e: Exception) {
                Log.e(
                    R.string.movie_home_view_model_log_tag.toString(),
                    R.string.movie_home_view_model_log_error_message.toString() + " ${e.message}"
                )
                _errorMessage.value = "Erro ao carregar filmes em breve: ${e.message}"
            }
        }
    }

    fun getSimularMovies(id: Int, apiKey: String) {
        viewModelScope.launch {
            try {
                _similarMovies.value = getSimilarMoviesUseCase(id,apiKey)

            } catch (e: Exception) {
                Log.e(
                    R.string.movie_home_view_model_log_tag.toString(),
                    R.string.movie_home_view_model_log_error_message.toString() + " ${e.message}"
                )
                _errorMessage.value = "Erro ao carregar filmes em breve: ${e.message}"
            }
        }
    }


}