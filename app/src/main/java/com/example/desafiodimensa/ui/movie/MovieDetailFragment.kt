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
import coil.transform.RoundedCornersTransformation
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.databinding.FragmentMovieDetailBinding
import com.example.desafiodimensa.extensions.viewBinding

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private val binding by viewBinding(FragmentMovieDetailBinding::bind)
    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var reviewAdapter: ReviewAdapter
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

        val recyclerViewReviews = binding.recyclerViewComments
        recyclerViewReviews.layoutManager = LinearLayoutManager(requireContext())

        relatedMoviesAdapter = MovieAdapter(emptyList()) { movie ->
        }
        recyclerViewRelatedMovies.adapter = relatedMoviesAdapter

        reviewAdapter = ReviewAdapter(emptyList())
        recyclerViewReviews.adapter = reviewAdapter

        viewModel.similarMovies.observe(viewLifecycleOwner, Observer { movies ->
            relatedMoviesAdapter.updateMovies(movies)
        })

        viewModel.reviewsComments.observe(viewLifecycleOwner, Observer { reviews ->
            reviewAdapter.updateReviews(reviews)
        })
        getInfosMovieDetail()
    }

    @SuppressLint("SetTextI18n")
    private fun getInfosMovieDetail() {
        val infosMovie = arguments?.getParcelable<Movie>("KEY")

        infosMovie?.let {
            binding.titleTextView.text = it.title
            binding.genresTextView.text = it.genres?.joinToString(", ") { genre -> genre.name }
            binding.synopsisTextView.text = it.overview
            binding.ratingTextView.text = "${it.vote_average}/10 média de votos"
            binding.durationTextView.text = "Duração: ${it.runtime} minutos"
            binding.posterImageView.load("https://image.tmdb.org/t/p/w500${it.poster_path}"){
                transformations(RoundedCornersTransformation(8f))
            }
            binding.posterImageViewDetail.load("https://image.tmdb.org/t/p/w500${it.backdrop_path}")


            viewModel.getSimularMovies(id = it.id, "13296e8a57292f8440cd14c19aa739ec")

            viewModel.getReviews(id = it.id, "13296e8a57292f8440cd14c19aa739ec")
        }
    }
}


