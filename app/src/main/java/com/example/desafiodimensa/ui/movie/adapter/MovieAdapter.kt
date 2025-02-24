package com.example.desafiodimensa.ui.movie.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.desafiodimensa.Constants
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.Movie
import com.google.android.material.imageview.ShapeableImageView

class MovieAdapter(
    private var movies: List<Movie>, private val onMovieClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { onMovieClick(movie) }
    }

    override fun getItemCount(): Int = movies.size

    fun updateMovies(newMovies: List<Movie>) {
        movies = newMovies
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val posterImageView: ShapeableImageView =
            itemView.findViewById(R.id.posterImageView)

        fun bind(movie: Movie) {
            val posterUrl = "${Constants.IMAGE_URL}${movie.poster_path}"

            posterImageView.load(posterUrl) {
                transformations(RoundedCornersTransformation(8f))
            }
        }
    }
}