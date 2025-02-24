package com.example.desafiodimensa.di

import com.example.desafiodimensa.data.remote.TMDbApiService
import com.example.desafiodimensa.domain.repository.MovieRepository
import com.example.desafiodimensa.domain.repository.ReviewRepository
import com.example.desafiodimensa.domain.usecase.GetComingSoonMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetMorePopularMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetNowPlayingMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetReviewsUseCase
import com.example.desafiodimensa.domain.usecase.GetSimilarMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetTopRatedMoviesUseCase
import com.example.desafiodimensa.ui.movie.detail.MovieDetailViewModel
import com.example.desafiodimensa.ui.movie.home.MovieHomeViewModel
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

    factory { GetNowPlayingMoviesUseCase(get()) }
    factory { GetComingSoonMoviesUseCase(get()) }
    factory { GetMorePopularMoviesUseCase(get()) }
    factory { GetTopRatedMoviesUseCase(get()) }

    // ViewModel
    viewModel { MovieDetailViewModel(get(), get()) }
    viewModel { MovieHomeViewModel(get(), get(), get(), get()) }
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
