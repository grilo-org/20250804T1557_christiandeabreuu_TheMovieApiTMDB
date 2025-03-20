package com.example.desafiodimensa.ui.movie.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.model.DetailsMovie
import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.data.model.Review
import com.example.desafiodimensa.domain.usecase.GetDetailsMovieUseCase
import com.example.desafiodimensa.domain.usecase.GetReviewsUseCase
import com.example.desafiodimensa.domain.usecase.GetSimilarMoviesUseCase
import com.example.desafiodimensa.util.Constants
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getReviewsUseCase: GetReviewsUseCase,
    private val getSimilarMoviesUseCase: GetSimilarMoviesUseCase,
    private val getDetailsMoviesUseCase: GetDetailsMovieUseCase
) : ViewModel() {

    private val _similarMovies = MutableLiveData<List<Movie>>()
    val similarMovies: LiveData<List<Movie>> get() = _similarMovies

    private val _reviewsComments = MutableLiveData<List<Review>?>()
    val reviewsComments: LiveData<List<Review>?> get() = _reviewsComments

    private val _detailsMovie = MutableLiveData<DetailsMovie>()
    val detailsMovie: LiveData<DetailsMovie> get() = _detailsMovie

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun getReviews(movieId: Int?) {
        viewModelScope.launch {
            try {
                movieId?.let {
                    _reviewsComments.value = getReviewsUseCase(movieId)
                }
            } catch (e: Exception) {
                Log.e("MovieDetailFragment", "Erro ao buscar filmes:" + " ${e.message}")
                _errorMessage.value =
                    R.string.movie_detail_view_model_log_error_message_movie.toString() + " ${e.message}"
            }
        }
    }

    fun getSimularMovies(id: Int ) {
        viewModelScope.launch {
            try {
                _similarMovies.value = getSimilarMoviesUseCase(id)
            } catch (e: Exception) {e
                Log.e("MovieDetailFragment", "Erro ao buscar filmes:" + " ${e.message}")
                _errorMessage.value =
                    R.string.movie_detail_view_model_log_error_message_movie.toString() + " ${e.message}"
            }
        }
    }

    fun getDetailsMovies(movieId: Int?) {
        viewModelScope.launch {
            try {
                movieId?.let {
                    _detailsMovie.value = getDetailsMoviesUseCase(movieId)
                }

            } catch (e: Exception) {
                Log.e("MovieDetailFragment", "Erro ao buscar filmes:" + " ${e.message}")
                _errorMessage.value =
                    R.string.movie_detail_view_model_log_error_message_movie.toString() + " ${e.message}"
            }
        }
    }


}