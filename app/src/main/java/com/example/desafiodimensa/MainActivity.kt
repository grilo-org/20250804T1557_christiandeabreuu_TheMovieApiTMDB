//package com.example.desafiodimensa
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.desafiodimensa.ui.movie.MovieAdapter
//import com.example.desafiodimensa.ui.movie.MovieViewModel
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var viewModel: MovieViewModel
//    private lateinit var nowPlayingAdapter: MovieAdapter
//    private lateinit var comingSoonAdapter: MovieAdapter
//    private lateinit var morePopularAdapter: MovieAdapter
//    private lateinit var topRatedAdapter: MovieAdapter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val recyclerViewNowPlaying = findViewById<RecyclerView>(R.id.recyclerViewNowPlaying)
//        recyclerViewNowPlaying.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        nowPlayingAdapter = MovieAdapter(emptyList(), ::onMoveClick)
//        recyclerViewNowPlaying.adapter = nowPlayingAdapter
//
//        val recyclerViewComingSoon = findViewById<RecyclerView>(R.id.recyclerViewComingSoon)
//        recyclerViewComingSoon.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        comingSoonAdapter = MovieAdapter(emptyList())
//        recyclerViewComingSoon.adapter = comingSoonAdapter
//
//        val recyclerViewMostPopular = findViewById<RecyclerView>(R.id.recyclerViewMostPopular)
//        recyclerViewMostPopular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        morePopularAdapter = MovieAdapter(emptyList())
//        recyclerViewMostPopular.adapter = morePopularAdapter
//
//        val recyclerViewTopRated = findViewById<RecyclerView>(R.id.recyclerViewTopRated)
//        recyclerViewTopRated.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        topRatedAdapter = MovieAdapter(emptyList())
//        recyclerViewTopRated.adapter = topRatedAdapter
//
//        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
//
//        viewModel.nowPlayingMovies.observe(this, Observer { movies ->
//            nowPlayingAdapter.updateMovies(movies) // Atualiza os dados do adapter existente
//        })
//
//        viewModel.comingSoonMovies.observe(this, Observer { movies ->
//            comingSoonAdapter.updateMovies(movies) // Atualiza os dados do adapter existente
//        })
//
//        viewModel.mostPopularMovies.observe(this, Observer { movies ->
//            morePopularAdapter.updateMovies(movies) // Atualiza os dados do adapter existente
//        })
//
//        viewModel.topRatedMovies.observe(this, Observer { movies ->
//            topRatedAdapter.updateMovies(movies)
//        })
//
//        // Busca os dados das três coleções
//        viewModel.fetchNowPlayingMovies("13296e8a57292f8440cd14c19aa739ec")
//        viewModel.fetchComingSoonMovies("13296e8a57292f8440cd14c19aa739ec")
//        viewModel.fetchMorePopularMovies("13296e8a57292f8440cd14c19aa739ec")
//        viewModel.fetchTopRatedMovies("13296e8a57292f8440cd14c19aa739ec")
//    }
//}