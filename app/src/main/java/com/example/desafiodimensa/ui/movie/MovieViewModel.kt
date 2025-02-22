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
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    fun fetchPopularMovies(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getPopularMovies(apiKey)
                Log.d("MovieViewModel", "Dados recebidos: ${response.results}")
                _movies.value = response.results
            } catch (e: Exception) {
                Log.e("MovieViewModel", "Erro ao buscar filmes: ${e.message}")
            }
        }
    }
}