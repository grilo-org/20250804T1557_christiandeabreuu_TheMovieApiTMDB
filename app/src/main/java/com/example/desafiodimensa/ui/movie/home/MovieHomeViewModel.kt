package com.example.desafiodimensa.ui.movie.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiodimensa.R
import com.example.desafiodimensa.RetrofitClient
import com.example.desafiodimensa.data.Movie
import kotlinx.coroutines.launch

class MovieHomeViewModel : ViewModel() {

    private val _nowPlayingMovies = MutableLiveData<List<Movie>>()
    val nowPlayingMovies: LiveData<List<Movie>> get() = _nowPlayingMovies

    private val _comingSoonMovies = MutableLiveData<List<Movie>>()
    val comingSoonMovies: LiveData<List<Movie>> get() = _comingSoonMovies

    private val _mostPopularMovies = MutableLiveData<List<Movie>>()
    val mostPopularMovies: LiveData<List<Movie>> get() = _mostPopularMovies

    private val _topRatedMovies = MutableLiveData<List<Movie>>()
    val topRatedMovies: LiveData<List<Movie>> get() = _topRatedMovies

    fun fetchNowPlayingMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getNowPlayingMovies(apiKey)
                Log.d(
                    R.string.movie_home_view_model_log_tag.toString(),
                    (R.string.movie_home_view_model_log_data_message.toString()) + " ${response.results}"
                )
                _nowPlayingMovies.value = response.results
            } catch (e: Exception) {
                Log.e(
                    R.string.movie_home_view_model_log_tag.toString(),
                    (R.string.movie_home_view_model_log_error_message.toString()) + " ${e.message}"
                )
            }
        }
    }

    fun fetchComingSoonMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getComingSoonMovies(apiKey)
                Log.d(
                    R.string.movie_home_view_model_log_tag.toString(),
                    (R.string.movie_home_view_model_log_data_message.toString()) + " ${response.results}"
                )
                _comingSoonMovies.value = response.results
            } catch (e: Exception) {
                Log.e(
                    R.string.movie_home_view_model_log_tag.toString(),
                    (R.string.movie_home_view_model_log_error_message.toString()) + " ${e.message}"
                )
            }
        }
    }

    fun fetchMorePopularMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getMorePopularMovies(apiKey)
                Log.d(
                    R.string.movie_home_view_model_log_tag.toString(),
                    (R.string.movie_home_view_model_log_data_message.toString()) + " ${response.results}"
                )
                _mostPopularMovies.value = response.results
            } catch (e: Exception) {
                Log.e(
                    R.string.movie_home_view_model_log_tag.toString(),
                    (R.string.movie_home_view_model_log_error_message.toString()) + " ${e.message}"
                )
            }
        }
    }

    fun fetchTopRatedMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getTopRatedMovies(apiKey)
                Log.d(
                    R.string.movie_home_view_model_log_tag.toString(),
                    (R.string.movie_home_view_model_log_data_message.toString()) + " ${response.results}"
                )
                _topRatedMovies.value = response.results
            } catch (e: Exception) {
                Log.e(
                    R.string.movie_home_view_model_log_tag.toString(),
                    (R.string.movie_home_view_model_log_error_message.toString()) + " ${e.message}"
                )
            }
        }
    }
}