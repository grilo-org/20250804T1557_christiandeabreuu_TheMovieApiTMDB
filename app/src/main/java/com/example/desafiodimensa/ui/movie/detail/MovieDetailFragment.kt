package com.example.desafiodimensa.ui.movie.detail

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.databinding.FragmentMovieDetailBinding
import com.example.desafiodimensa.extensions.viewBinding
import com.example.desafiodimensa.ui.movie.adapter.MovieAdapter
import com.example.desafiodimensa.ui.movie.adapter.ReviewAdapter
import com.example.desafiodimensa.util.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

    private val viewModel: MovieDetailViewModel by viewModel()

    private val binding by viewBinding(FragmentMovieDetailBinding::bind)
    private lateinit var reviewAdapter: ReviewAdapter
    private var movie: Movie? = null
    private lateinit var relatedMoviesAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movie = it.getParcelable(Constants.Movie)
        }
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewRelatedMovies = binding.recyclerViewMoviesDetail
        recyclerViewRelatedMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val recyclerViewReviews = binding.recyclerViewComments
        recyclerViewReviews.layoutManager = LinearLayoutManager(requireContext())

        relatedMoviesAdapter = MovieAdapter(emptyList()) {}
        recyclerViewRelatedMovies.adapter = relatedMoviesAdapter

        reviewAdapter = ReviewAdapter(emptyList())
        recyclerViewReviews.adapter = reviewAdapter

        viewModel.similarMovies.observe(viewLifecycleOwner) { movies ->
            relatedMoviesAdapter.updateMovies(movies)
        }

        viewModel.reviewsComments.observe(viewLifecycleOwner) { reviews ->
            reviewAdapter.updateReviews(reviews)
        }

        viewModel.detailsMovie.observe(viewLifecycleOwner) { details ->
            binding.genresTextView.text = details.genres.joinToString(", ") { genre -> genre.name }
            val formattedDuration = formatMovieDuration(details.runtime?.toInt() ?: 100)
            binding.durationTextView.text = " $formattedDuration"
        }


        viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
        getInfosMovieDetail()
        goToBack()
    }

    private fun goToBack() {
        binding.buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("SetTextI18n")
    private fun getInfosMovieDetail() {
        val infosMovie = arguments?.getParcelable(Constants.KEY, Movie::class.java)

        infosMovie?.let {
            binding.titleTextView.text = it.title
            binding.synopsisTextView.text = it.overview
            binding.ratingTextView.text = "${it.voteAverage}/10 média de votos"

            binding.posterImageView.load("${getString(R.string.movie_detail_fragment_base_image_url)}${it.posterPath}") {
                transformations(RoundedCornersTransformation(50f)) }
            binding.posterImageViewDetail.load("${getString(R.string.movie_detail_fragment_base_image_url)}${it.backdropPath}")

            viewModel.getSimularMovies(id = it.id, Constants.API_KEY)
            viewModel.getReviews(movieId = it.id)
            viewModel.getDetailsMovies(movieId = it.id)
        }
    }

    private fun formatMovieDuration(durationInMinutes: Int): String {
        val hours = durationInMinutes / 60
        val minutes = durationInMinutes % 60
        return "${hours}hora(s) ${minutes}minuto(s)"
    }
}


