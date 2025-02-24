package com.example.desafiodimensa.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Review(
    val author: String,
    val content: String,
):Parcelable
