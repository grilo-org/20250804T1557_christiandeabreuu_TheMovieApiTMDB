package com.example.desafiodimensa.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("original_language") val language: String,
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("runtime") val runtime: Int?,
    val genres: List<Genre>?
) : Parcelable
