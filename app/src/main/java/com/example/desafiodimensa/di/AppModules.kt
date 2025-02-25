package com.example.desafiodimensa.di

import com.example.desafiodimensa.data.remote.TMDbApiService
import com.example.desafiodimensa.domain.repository.MovieRepository
import com.example.desafiodimensa.domain.repository.ReviewRepository
import com.example.desafiodimensa.domain.usecase.GetComingSoonMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetDetailsMovieUseCase
import com.example.desafiodimensa.domain.usecase.GetMorePopularMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetNowPlayingMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetReviewsUseCase
import com.example.desafiodimensa.domain.usecase.GetSimilarMoviesUseCase
import com.example.desafiodimensa.domain.usecase.GetTopRatedMoviesUseCase
import com.example.desafiodimensa.ui.movie.detail.MovieDetailViewModel
import com.example.desafiodimensa.ui.movie.home.MovieHomeViewModel
import com.example.desafiodimensa.util.Constants
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    factory { MovieRepository(get()) }
    factory { ReviewRepository(get()) }

    factory { GetReviewsUseCase(get()) }
    factory { GetSimilarMoviesUseCase(get()) }
    factory { GetDetailsMovieUseCase(get()) }

    factory { GetNowPlayingMoviesUseCase(get()) }
    factory { GetComingSoonMoviesUseCase(get()) }
    factory { GetMorePopularMoviesUseCase(get()) }
    factory { GetTopRatedMoviesUseCase(get()) }

    viewModel { MovieDetailViewModel(get(), get(), get()) }
    viewModel { MovieHomeViewModel(get(), get(), get(), get()) }
}

val networkModule = module {
    single {
        Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(TMDbApiService::class.java)
    }
}
