package com.example.desafiodimensa.ui.movie

import MovieAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.databinding.FragmentMovieDetailBinding
import com.example.desafiodimensa.extensions.viewBinding

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private val binding by viewBinding(FragmentMovieDetailBinding::bind)
    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var adapter: MovieAdapter

    private var movie: Movie? = null
    private lateinit var relatedMoviesAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = it.getParcelable("movie")
        }

        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewRelatedMovies = binding.recyclerViewMoviesDetail
        recyclerViewRelatedMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        relatedMoviesAdapter = MovieAdapter(emptyList()) { movie ->
        }
        recyclerViewRelatedMovies.adapter = relatedMoviesAdapter

        viewModel.similarMovies.observe(viewLifecycleOwner, Observer { movies ->
            relatedMoviesAdapter.updateMovies(movies)
        })
        getInfosMovieDetail()
    }

    @SuppressLint("SetTextI18n")
    private fun getInfosMovieDetail() {
        val infosMovie = arguments?.getParcelable<Movie>("KEY")

        infosMovie?.let {
            binding.titleTextView.text = it.title
            binding.synopsisTextView.text = it.overview
            binding.ratingTextView.text = it.vote_average.toString()
            binding.durationTextView.text = "Duração: ${it.runtime} minutos"
            binding.posterImageView.load("https://image.tmdb.org/t/p/w500${it.poster_path}")
            binding.posterImageViewDetail.load("https://image.tmdb.org/t/p/w500${it.backdrop_path}")
        }
    }
}


