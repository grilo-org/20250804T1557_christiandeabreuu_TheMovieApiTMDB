package com.example.desafiodimensa.ui.movie.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiodimensa.Constants
import com.example.desafiodimensa.R
import com.example.desafiodimensa.RetrofitClient
import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.data.Review
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel() {

    private val _similarMovies = MutableLiveData<List<Movie>>()
    val similarMovies: LiveData<List<Movie>> get() = _similarMovies

    private val _reviewsComments = MutableLiveData<List<Review>?>()
    val reviewsComments: LiveData<List<Review>?> get() = _reviewsComments

    fun getReviews(id: Int, apiKey: String) {
        viewModelScope.launch {
            try {
                val response =
                    RetrofitClient.instance.getReviews(movieId = id, apiKey = Constants.API_KEY)
                _reviewsComments.value = response.reviewResults
                Log.d(
                    R.string.movie_home_view_model_log_tag.toString(),
                    R.string.movie_detail_view_model_log_reviews_message.toString() + " ${response.reviewResults}"
                )
            } catch (e: Exception) {
                Log.e(
                    R.string.movie_home_view_model_log_tag.toString(),
                    R.string.movie_detail_view_model_log_error_message_review.toString() + " ${e.message}"
                )
            }
        }
    }

    fun getSimularMovies(id: Int, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getSimilarMovies(
                    movieId = id, apiKey = Constants.API_KEY
                )
                _similarMovies.value = response.results
            } catch (e: Exception) {
                Log.e(
                    R.string.movie_home_view_model_log_tag.toString(),
                    R.string.movie_detail_view_model_log_error_message_movie.toString() + " ${e.message}"
                )
            }
        }
    }
}