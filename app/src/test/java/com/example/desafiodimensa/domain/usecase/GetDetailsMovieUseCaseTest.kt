package com.example.desafiodimensa.domain.usecase

import com.example.desafiodimensa.data.model.DetailsMovie
import com.example.desafiodimensa.data.model.Genre
import com.example.desafiodimensa.domain.repository.MovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetDetailsMovieUseCaseTest {

    @Test
    fun `test invoke should return details movie`() = runBlocking {
        // Arrange
        val mockRepository = mockk<MovieRepository>() // Mock do MovieRepository
        val useCase = GetDetailsMovieUseCase(mockRepository)
        val listGenres = listOf(Genre("1"),Genre("2"),Genre("3"))
        val movieId = 1
        val apiKey = "fakeApiKey"
        val expectedDetailsMovie = DetailsMovie(backdropPath = "url1",
            originalLanguage = "pt",
            originalTitle = "Another Movie",
            posterPath = "url2",
            id = 2,
            title = "Another Movie",
            overview = "This is another movie overview.",
            voteAverage = 7.8,
            language = "es",
            runtime = 95,
            voteCount = 100,
            genres = listGenres
        )

        // Define o comportamento do mock
        coEvery { mockRepository.getDetailsMovie(movieId, apiKey) } returns expectedDetailsMovie

        // Act
        val result = useCase(movieId, apiKey) // Chama o método invoke

        // Assert
        assertEquals(expectedDetailsMovie, result) // Verifica se o resultado é o esperado
    }

    @Test
    fun `test invoke should return correct movie details`() = runBlocking {
        // Arrange
        val listGenres = listOf(Genre("1"),Genre("2"),Genre("3"))
        val mockRepository = mockk<MovieRepository>() // Mock do MovieRepository
        val useCase = GetDetailsMovieUseCase(mockRepository)

        val movieId = 2
        val apiKey = "fakeApiKey"
        val expectedDetailsMovie = DetailsMovie(backdropPath = "url1",
            originalLanguage = "pt",
            originalTitle = "Another Movie",
            posterPath = "url2",
            id = 2,
            title = "Another Movie",
            overview = "This is another movie overview.",
            voteAverage = 7.8,
            language = "es",
            runtime = 95,
            voteCount = 100,
            genres = listGenres
        )

        // Define o comportamento do mock
        coEvery { mockRepository.getDetailsMovie(movieId, apiKey) } returns expectedDetailsMovie

        // Act
        val result = useCase(movieId, apiKey) // Chama o método invoke

        // Assert
        assertEquals(expectedDetailsMovie, result) // Verifica se o resultado é o esperado
    }
}