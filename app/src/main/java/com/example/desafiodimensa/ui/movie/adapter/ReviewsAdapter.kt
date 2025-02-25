package com.example.desafiodimensa.ui.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiodimensa.R
import com.example.desafiodimensa.data.model.Review
import com.example.desafiodimensa.databinding.ItemComentsDetailBinding

class ReviewAdapter(
    private var listReview: List<Review>,
) : RecyclerView.Adapter<ReviewAdapter.ReviewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        val binding =
            ItemComentsDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        val reviews = listReview[position]
        holder.bind(reviews)
    }

    override fun getItemCount(): Int = listReview.size

    fun updateReviews(newReviews: List<Review>?) {
        if (newReviews.isNullOrEmpty()) {
            val defaultReview = listOf(
                Review(
                    author = R.string.reviews_adapter_name_1.toString(),
                    content = R.string.reviews_adapter_comments_1.toString()
                ), Review(
                    author = R.string.reviews_adapter_name_2.toString(),
                    content = R.string.reviews_adapter_comments_2.toString()
                ), Review(
                    author = R.string.reviews_adapter_name_3.toString(),
                    content = R.string.reviews_adapter_comments_3.toString()
                )
            )
            listReview = defaultReview
            notifyDataSetChanged()

        } else {
            listReview = newReviews
            notifyDataSetChanged()
        }
    }

    class ReviewsViewHolder(private val binding: ItemComentsDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(review: Review) {
            binding.title.text = review.author
            binding.subtitle.text = review.content
        }
    }
}