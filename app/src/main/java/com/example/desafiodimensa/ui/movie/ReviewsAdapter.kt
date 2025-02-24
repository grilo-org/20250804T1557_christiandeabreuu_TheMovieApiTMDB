package com.example.desafiodimensa.ui.movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.Movie
import com.example.desafiodimensa.data.Review
import com.example.desafiodimensa.databinding.ItemComentsDetailBinding
import com.google.android.material.imageview.ShapeableImageView

 class ReviewAdapter(
    private var listReview: List<Review>,
) : RecyclerView.Adapter<ReviewAdapter.ReviewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        val binding = ItemComentsDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        val reviews = listReview[position]
        holder.bind(reviews)
    }

    override fun getItemCount(): Int = listReview.size

    fun updateReviews(newReviews: List<Review>?) {
        if(newReviews.isNullOrEmpty()) {
            val defaultReview = listOf(
                Review(
                    author = "Alexandra",
                    content = "It was great. This movie was a continuation of the Avengers of the Eternal War. See it first and then this movie"
            ),Review(
                author = "Jason",
                content = "The best hero is Iron Man. Not because of his clothes, but because of his personality"
            ),Review(
                author = "Amanda",
                content = "It was interesting. I think Loki and Stark and Captain America will die soon"
            ))
            listReview = defaultReview
            notifyDataSetChanged()

        }else{
            listReview = newReviews
            notifyDataSetChanged()
        }

    }

    class ReviewsViewHolder(val binding: ItemComentsDetailBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(review: Review) {
        binding.title.text = review.author
        binding.subtitle.text = review.content
        }
    }
}