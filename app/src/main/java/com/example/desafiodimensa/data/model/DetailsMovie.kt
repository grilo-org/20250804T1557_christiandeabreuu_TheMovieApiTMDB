package com.example.desafiodimensa.data.model

import com.google.gson.annotations.SerializedName


data class DetailsMovie(

    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genres") val genres: List<Genre>,
    @SerializedName("id") val id: Int,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("language") val language: String,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int
)

