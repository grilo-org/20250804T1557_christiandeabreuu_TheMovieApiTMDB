package com.example.desafiodimensa.ui.movie.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.desafiodimensa.Constants
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.databinding.FragmentMovieDetailBinding
import com.example.desafiodimensa.extensions.viewBinding
import com.example.desafiodimensa.ui.movie.adapter.MovieAdapter
import com.example.desafiodimensa.ui.movie.adapter.ReviewAdapter

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private val binding by viewBinding(FragmentMovieDetailBinding::bind)
    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var reviewAdapter: ReviewAdapter
    private var movie: Movie? = null
    private lateinit var relatedMoviesAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = it.getParcelable(Constants.Movie)
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
        goToBack()
    }

    private fun goToBack() {
        binding.buttonBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getInfosMovieDetail() {
        val infosMovie = arguments?.getParcelable<Movie>(Constants.KEY)

        infosMovie?.let {
            binding.titleTextView.text = it.title
            binding.genresTextView.text = it.genres?.joinToString(", ") { genre -> genre.name }
            binding.synopsisTextView.text = it.overview
            binding.ratingTextView.text = "${it.vote_average}/10 média de votos"
            binding.durationTextView.text = "Duração: ${it.runtime} minutos"
            binding.posterImageView.load("${getString(R.string.movie_detail_fragment_base_image_url)}${it.poster_path}") {
                transformations(RoundedCornersTransformation(50f))
            }
            binding.posterImageViewDetail.load("${getString(R.string.movie_detail_fragment_base_image_url)}${it.backdrop_path}")

            viewModel.getSimularMovies(id = it.id, Constants.API_KEY)

            viewModel.getReviews(id = it.id, Constants.API_KEY)
        }
    }
}


