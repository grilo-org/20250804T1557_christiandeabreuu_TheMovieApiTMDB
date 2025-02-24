package com.example.desafiodimensa.ui.movie.home

import com.example.desafiodimensa.ui.movie.adapter.MovieAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.Movie

class MovieHomeFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var nowPlayingAdapter: MovieAdapter
    private lateinit var comingSoonAdapter: MovieAdapter
    private lateinit var morePopularAdapter: MovieAdapter
    private lateinit var topRatedAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recyclerViewNowPlaying = view.findViewById<RecyclerView>(R.id.recyclerViewNowPlaying)
        recyclerViewNowPlaying.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        nowPlayingAdapter = MovieAdapter(emptyList(), ::onMoveClick)
        recyclerViewNowPlaying.adapter = nowPlayingAdapter

        val recyclerViewComingSoon = view.findViewById<RecyclerView>(R.id.recyclerViewComingSoon)
        recyclerViewComingSoon.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        comingSoonAdapter = MovieAdapter(emptyList(), ::onMoveClick)
        recyclerViewComingSoon.adapter = comingSoonAdapter

        val recyclerViewMostPopular = view.findViewById<RecyclerView>(R.id.recyclerViewMostPopular)
        recyclerViewMostPopular.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        morePopularAdapter = MovieAdapter(emptyList(), ::onMoveClick)
        recyclerViewMostPopular.adapter = morePopularAdapter

        val recyclerViewTopRated = view.findViewById<RecyclerView>(R.id.recyclerViewTopRated)
        recyclerViewTopRated.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        topRatedAdapter = MovieAdapter(emptyList(), ::onMoveClick)
        recyclerViewTopRated.adapter = topRatedAdapter

        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        viewModel.nowPlayingMovies.observe(this.viewLifecycleOwner, Observer { movies ->
            nowPlayingAdapter.updateMovies(movies)
        })

        viewModel.comingSoonMovies.observe(this.viewLifecycleOwner, Observer { movies ->
            comingSoonAdapter.updateMovies(movies)
        })

        viewModel.mostPopularMovies.observe(this.viewLifecycleOwner, Observer { movies ->
            morePopularAdapter.updateMovies(movies)
        })

        viewModel.topRatedMovies.observe(this.viewLifecycleOwner, Observer { movies ->
            topRatedAdapter.updateMovies(movies)
        })

        viewModel.fetchNowPlayingMovies("13296e8a57292f8440cd14c19aa739ec")
        viewModel.fetchComingSoonMovies("13296e8a57292f8440cd14c19aa739ec")
        viewModel.fetchMorePopularMovies("13296e8a57292f8440cd14c19aa739ec")
        viewModel.fetchTopRatedMovies("13296e8a57292f8440cd14c19aa739ec")
    }

    private fun onMoveClick(movie: Movie) {
        val bundle = bundleOf("KEY" to movie)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_movieHomeFragment_to_movieDetailFragment, bundle)
    }

}
