package com.example.desafiodimensa.ui.movie

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.desafiodimensa.R
import com.example.desafiodimensa.databinding.FragmentMovieDetailBinding
import com.example.desafiodimensa.extensions.viewBinding

class MovieDetailFragment: Fragment(R.layout.fragment_movie_detail) {

    private val binding by viewBinding(FragmentMovieDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToHome()
    }

    private fun goToHome() {
//        binding.testButton.setOnClickListener {
//            findNavController().navigate(R.id.action_movieHomeFragment_to_movieDetailFragment)
//        }
    }
}