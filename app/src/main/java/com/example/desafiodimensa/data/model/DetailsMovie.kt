package com.example.desafiodimensa.data.model
import com.google.gson.annotations.SerializedName
import org.intellij.lang.annotations.Language


data class DetailsMovie (

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
//@SerializedName("video") val video: Boolean,
//@SerializedName("release_date") val releaseDate: String,
//@SerializedName("revenue") val revenue: Int,
//@SerializedName("popularity") val popularity: Double,
//@SerializedName("homepage") val homepage: String?,
//@SerializedName("adult") val adult: Boolean,
//@SerializedName("belongs_to_collection") val belongsToCollection: Any?, // Pode ser null ou um objeto
//@SerializedName("budget") val budget: Int,
//@SerializedName("imdb_id") val imdbId: String?,
//@SerializedName("origin_country") val originCountry: List<String>,
//@SerializedName("status") val status: String,
//@SerializedName("tagline") val tagline: String?,

