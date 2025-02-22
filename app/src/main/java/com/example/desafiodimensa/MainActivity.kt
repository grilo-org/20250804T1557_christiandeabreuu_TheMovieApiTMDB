package com.example.desafiodimensa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodimensa.ui.movie.MovieAdapter
import com.example.desafiodimensa.ui.movie.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        viewModel.movies.observe(this, Observer { movies ->
            adapter = MovieAdapter(movies)
            recyclerView.adapter = adapter
        })

        viewModel.fetchPopularMovies("13296e8a57292f8440cd14c19aa739ec")
    }
}