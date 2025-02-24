package com.example.desafiodimensa.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val backdrop_path: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
    val runtime: Int,
    val genres: List<Genre>?
) : Parcelable
