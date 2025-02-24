package com.example.desafiodimensa.ui.movie.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiodimensa.Constants
import com.example.desafiodimensa.R
import com.example.desafiodimensa.RetrofitClient
import com.example.desafiodimensa.data.Movie
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

    fun fetchNowPlayingMovies(apiKey: String) {
        viewModelScope.launch {
            _nowPlayingMovies.value = getNowPlayingMoviesUseCase(apiKey)
        }
    }

    fun fetchComingSoonMovies(apiKey: String) {
        viewModelScope.launch {
            _comingSoonMovies.value = getComingSoonMoviesUseCase(apiKey)
        }
    }

    fun fetchMorePopularMovies(apiKey: String) {
        viewModelScope.launch {
            _mostPopularMovies.value = getMorePopularMoviesUseCase(apiKey)
        }
    }

    fun fetchTopRatedMovies(apiKey: String) {
        viewModelScope.launch {
            _topRatedMovies.value = getTopRatedMoviesUseCase(apiKey)
        }
    }
}