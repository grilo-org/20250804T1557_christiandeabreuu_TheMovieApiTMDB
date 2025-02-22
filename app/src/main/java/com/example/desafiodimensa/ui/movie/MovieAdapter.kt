package com.example.desafiodimensa.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.databinding.ItemMovieBinding

class MovieAdapter(private var movies: List<Movie>, private val clickDetail: (movie:Movie) -> Unit) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    fun updateMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.binding.posterImageView.setOnClickListener {
            clickDetail(movie)
        }
    }

    override fun getItemCount(): Int = movies.size

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        private val posterImageView: ImageView = itemView.findViewById(R.id.posterImageView)

        fun bind(movie: Movie) {
            val posterUrl = "https://image.tmdb.org/t/p/w500${movie.poster_path}"

            posterImageView.load(posterUrl)
        }
    }
}