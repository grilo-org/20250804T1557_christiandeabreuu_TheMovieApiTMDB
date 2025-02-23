package com.example.desafiodimensa.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiodimensa.RetrofitClient
import com.example.desafiodimensa.data.Movie
import kotlinx.coroutines.launch

class MovieDetailViewModel : ViewModel() {

    private val _similarMovies = MutableLiveData<List<Movie>>()
    val similarMovies: LiveData<List<Movie>> get() = _similarMovies

    fun getTopRatedDetail(apiKey: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getTopRatedMovies(apiKey = "13296e8a57292f8440cd14c19aa739ec")
                _similarMovies.value = response.results
            } catch (e: Exception) {
                Log.e("MovieDetailViewModel", "Erro ao buscar filmes relacionados: ${e.message}")
            }
        }
    }
}