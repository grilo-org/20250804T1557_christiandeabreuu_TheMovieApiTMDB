package com.example.desafiodimensa.ui.movie.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.domain.usecase.GetComingSoonMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetMorePopularMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetNowPlayingMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetTopRatedMoviesUseCase
import kotlinx.coroutines.launch

class MovieHomeViewModel(
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getComingSoonMoviesUseCase: GetComingSoonMoviesUseCase,
    private val getMorePopularMoviesUseCase: GetMorePopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    private val _nowPlayingMovies = MutableLiveData<List<Movie>>()
    val nowPlayingMovies: LiveData<List<Movie>> get() = _nowPlayingMovies

    private val _comingSoonMovies = MutableLiveData<List<Movie>>()
    val comingSoonMovies: LiveData<List<Movie>> get() = _comingSoonMovies

    private val _mostPopularMovies = MutableLiveData<List<Movie>>()
    val mostPopularMovies: LiveData<List<Movie>> get() = _mostPopularMovies

    private val _topRatedMovies = MutableLiveData<List<Movie>>()
    val topRatedMovies: LiveData<List<Movie>> get() = _topRatedMovies

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun fetchNowPlayingMovies() {
        viewModelScope.launch {
            try {
                _nowPlayingMovies.value = getNowPlayingMoviesUseCase()
            } catch (e: Exception) {
                Log.e("MovieHomeViewModel", "Erro ao buscar filmes:" + " ${e.message}")
                _errorMessage.value =
                    R.string.movie_home_view_model_log_error_message.toString() + " ${e.message}"
            }
        }
    }

    fun fetchComingSoonMovies() {
        viewModelScope.launch {
            try {
                _comingSoonMovies.value = getComingSoonMoviesUseCase()
            } catch (e: Exception) {
                Log.e("MovieHomeViewModel", "Erro ao buscar filmes:" + " ${e.message}")
                _errorMessage.value =
                    R.string.movie_home_view_model_log_error_message.toString() + "${e.message}"
            }
        }
    }

    fun fetchMorePopularMovies() {
        viewModelScope.launch {
            try {
                _mostPopularMovies.value = getMorePopularMoviesUseCase()
            } catch (e: Exception) {
                Log.e("MovieHomeViewModel", "Erro ao buscar filmes:" + " ${e.message}")
                _errorMessage.value =
                    R.string.movie_home_view_model_log_error_message.toString() + " ${e.message}"
            }
        }
    }

    fun fetchTopRatedMovies() {
        viewModelScope.launch {
            try {
                _topRatedMovies.value = getTopRatedMoviesUseCase()

            } catch (e: Exception) {
                Log.e("MovieHomeViewModel", "Erro ao buscar filmes:" + " ${e.message}")
                _errorMessage.value =
                    R.string.movie_home_view_model_log_error_message.toString() + " ${e.message}"
            }
        }
    }
}


