//package com.example.desafiodimensa.ui.movie.detail
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.example.desafiodimensa.data.model.Movie
//import com.example.desafiodimensa.domain.usecase.GetSimilarMoviesUseCase
//import com.example.desafiodimensa.ui.movie.home.MovieHomeViewModel
//import io.mockk.coEvery
//import io.mockk.mockk
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.TestCoroutineDispatcher
//import kotlinx.coroutines.test.resetMain
//import kotlinx.coroutines.test.runBlockingTest
//import kotlinx.coroutines.test.setMain
//import org.junit.After
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//
//@ExperimentalCoroutinesApi
//class MovieHomeViewModelTest {
//
//    @get:Rule
//    val instantTaskExecutorRule = InstantTaskExecutorRule() // Para LiveData
//
//    private val testDispatcher = TestCoroutineDispatcher()
//
//    private lateinit var viewModel: MovieHomeViewModel
//    private val getSimilarMoviesUseCase: GetSimilarMoviesUseCase = mockk()
//
//    @Before
//    fun setup() {
//        Dispatchers.setMain(testDispatcher) // Define o dispatcher de teste
//        viewModel = MovieHomeViewModel(getSimilarMoviesUseCase)
//    }
//
//    @After
//    fun tearDown() {
//        Dispatchers.resetMain() // Reseta o dispatcher
//        testDispatcher.cleanupTestCoroutines()
//    }
//
//    @Test
//    fun `getSimularMovies should update similarMovies LiveData when successful`() = runBlockingTest {
//        // Arrange
//        val movieId = 123
//        val apiKey = "your_api_key"
//        val expectedMovies = listOf(Movie(1, "Movie 1"), Movie(2, "Movie 2"))
//
//        coEvery { getSimilarMoviesUseCase(movieId, apiKey) } returns expectedMovies
//
//        // Act
//        viewModel.ge(movieId, apiKey)
//
//        // Assert
//        assertEquals(expectedMovies, viewModel.similarMovies.value)
//    }
//
//    @Test
//    fun `getSimularMovies should update errorMessage LiveData when an exception occurs`() = runBlockingTest {
//        // Arrange
//        val movieId = 123
//        val apiKey = "your_api_key"
//        val exceptionMessage = "Network error"
//
//        coEvery { getSimilarMoviesUseCase(movieId, apiKey) } throws Exception(exceptionMessage)
//
//        // Act
//        viewModel.getSimularMovies(movieId, apiKey)
//
//        // Assert
//        assertEquals("Erro ao carregar filmes em breve: $exceptionMessage", viewModel.errorMessage.value)
//    }
//}