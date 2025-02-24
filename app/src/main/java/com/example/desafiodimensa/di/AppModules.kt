package com.example.desafiodimensa.di

import com.example.desafiodimensa.data.TMDbApiService
import com.example.desafiodimensa.domain.repository.MovieRepository
import com.example.desafiodimensa.domain.repository.ReviewRepository
import com.example.desafiodimensa.domain.usecase.GetReviewsUseCase
import com.example.desafiodimensa.domain.usecase.GetSimilarMoviesUseCase
import com.example.desafiodimensa.ui.movie.detail.MovieDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    // Repositório
    single { MovieRepository(get()) }
    single { ReviewRepository(get()) }

    // UseCases
    single { GetReviewsUseCase(get()) }
    single { GetSimilarMoviesUseCase(get()) }

    // ViewModel
    viewModel { MovieDetailViewModel(get(), get()) }
}

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TMDbApiService::class.java)
    }
}
