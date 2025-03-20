package com.example.desafiodimensa.ui.movie.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.databinding.FragmentMovieHomeBinding
import com.example.desafiodimensa.ui.movie.adapter.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieHomeFragment : Fragment() {

    private lateinit var binding: FragmentMovieHomeBinding
    private val viewModel: MovieHomeViewModel by viewModel()
    private lateinit var nowPlayingAdapter: MovieAdapter
    private lateinit var comingSoonAdapter: MovieAdapter
    private lateinit var morePopularAdapter: MovieAdapter
    private lateinit var topRatedAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerViews()
        setupViewModel()
        fetchMovies()
    }

    private fun setupRecyclerViews() {
        nowPlayingAdapter = createAdapter()
        comingSoonAdapter = createAdapter()
        morePopularAdapter = createAdapter()
        topRatedAdapter = createAdapter()

        with(binding) {
            recyclerViewNowPlaying.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewNowPlaying.adapter = nowPlayingAdapter

            recyclerViewComingSoon.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewComingSoon.adapter = comingSoonAdapter

            recyclerViewMostPopular.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewMostPopular.adapter = morePopularAdapter

            recyclerViewTopRated.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewTopRated.adapter = topRatedAdapter
        }
    }

    private fun createAdapter(): MovieAdapter {
        return MovieAdapter(emptyList(), ::onMoveClick)
    }

    private fun setupViewModel() {
        viewModel.nowPlayingMovies.observe(viewLifecycleOwner) { movies ->
            nowPlayingAdapter.updateMovies(movies)
        }

        viewModel.comingSoonMovies.observe(viewLifecycleOwner) { movies ->
            comingSoonAdapter.updateMovies(movies)
        }

        viewModel.mostPopularMovies.observe(viewLifecycleOwner) { movies ->
            morePopularAdapter.updateMovies(movies)
        }

        viewModel.topRatedMovies.observe(viewLifecycleOwner) { movies ->
            topRatedAdapter.updateMovies(movies)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            error?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchMovies() {
        viewModel.fetchNowPlayingMovies()
        viewModel.fetchComingSoonMovies()
        viewModel.fetchMorePopularMovies()
        viewModel.fetchTopRatedMovies()
    }

    private fun onMoveClick(movie: Movie) {
        val bundle = bundleOf("KEY" to movie)
        NavHostFragment.findNavController(this).navigate(
            R.id.action_movieHomeFragment_to_movieDetailFragment, bundle
        )
    }
}
