package com.example.desafiodimensa.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    val name: String
): Parcelable
