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
        // Recebe os argumentos passados para o fragmento
        arguments?.let {
            movie = it.getParcelable("movie")
        }
        // Inicialização do ViewModel
        viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie?.let {

//            binding.posterImageView.load("https://image.tmdb.org/t/p/w500${it.backdropPath}")
//            binding.titleTextView.text = it.title
//            binding.durationTextView.text = "Duração: ${it.duration} minutos"
//            binding.genresTextView.text = it.genres.toString()
//            binding.posterImageViewDetail.load("https://image.tmdb.org/t/p/w500${it.posterPath}")
//            binding.synopsisTextView.text = it.overview
//            view.findViewById<TextView>(R.id.synopsisTextView).text = it.overview
        }
// Configuração do RecyclerView para filmes relacionados
        val recyclerViewRelatedMovies = binding.recyclerViewMoviesDetail
        recyclerViewRelatedMovies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Inicializa o adapter para filmes relacionados
        relatedMoviesAdapter = MovieAdapter(emptyList()) { movie ->
            // Navega para o detalhe do filme relacionado
            val bundle = Bundle().apply {
                putParcelable("movie", movie)
            }
        }
        recyclerViewRelatedMovies.adapter = relatedMoviesAdapter

        // Observa os filmes relacionados no ViewModel
        viewModel.similarMovies.observe(viewLifecycleOwner, Observer { movies ->
            relatedMoviesAdapter.updateMovies(movies)
        })
        getInfosMovieDetail()
    }

    @SuppressLint("SetTextI18n")
    private fun getInfosMovieDetail() {
        val character = arguments?.getParcelable<Movie>("KEY")

        character?.let {
//            Picasso.get().load(it.image).into(binding.ivDetailCharacter)
            binding.titleTextView.text = it.title
            binding.synopsisTextView.text = it.overview
            binding.ratingTextView.text = it.vote_average.toString()
            binding.durationTextView.text = "Duração: ${it.runtime} minutos"
            binding.posterImageView.load("https://image.tmdb.org/t/p/w500${it.poster_path}")
            binding.posterImageViewDetail.load("https://image.tmdb.org/t/p/w500${it.backdrop_path}")
//
            //            binding.durationTextView.text = "Duração: ${it.duration} minutos"
//            binding.s.text = "STATUS : " + it.status
//            binding.tvDetailSpecies.text = "ESPECIE : " + it.species
//            binding.tvDetailGender.text = getString(R.string.gender) + it.gender
//            binding.tvDetailId.text = "Id : " + it.id.toString()

        }
    }

}


