package com.example.desafiodimensa.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiodimensa.RetrofitClient
import com.example.desafiodimensa.data.Movie
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

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
                Log.d("MovieViewModel", "Dados recebidos: ${response.results}")
                _nowPlayingMovies.value = response.results
            } catch (e: Exception) {
                Log.e("MovieViewModel", "Erro ao buscar filmes: ${e.message}")
            }
        }
    }

    fun fetchComingSoonMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getComingSoonMovies(apiKey)
                Log.d("MovieViewModel", "Dados recebidos: ${response.results}")
                _comingSoonMovies.value = response.results
            } catch (e: Exception) {
                Log.e("MovieViewModel", "Erro ao buscar filmes mais votados: ${e.message}")
            }
        }
    }

    fun fetchMorePopularMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getMorePopularMovies(apiKey)
                Log.d("MovieViewModel", "Dados recebidos: ${response.results}")
                _mostPopularMovies.value = response.results
            } catch (e: Exception) {
                Log.e("MovieViewModel", "Erro ao buscar filmes: ${e.message}")
            }
        }
    }

    fun fetchTopRatedMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getTopRatedMovies(apiKey)
                Log.d("MovieViewModel", "Dados recebidos: ${response.results}")
                _topRatedMovies.value = response.results
            } catch (e: Exception) {
                Log.e("MovieViewModel", "Erro ao buscar filmes: ${e.message}")
            }
        }
    }
}