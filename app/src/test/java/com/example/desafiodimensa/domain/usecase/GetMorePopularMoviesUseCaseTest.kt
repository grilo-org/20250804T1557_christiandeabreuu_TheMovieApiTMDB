package com.example.desafiodimensa.domain.usecase

import com.example.desafiodimensa.data.model.Genre
import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.domain.repository.MovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetMorePopularMoviesUseCaseTest {

    @Test
    fun `test invoke should return list of popular movies`() = runBlocking {
        // Arrange
        val mockRepository = mockk<MovieRepository>() // Mock do MovieRepository
        val useCase = GetMorePopularMoviesUseCase(mockRepository)
        val listGenres = listOf(Genre("1"), Genre("2"), Genre("3"))
        val apiKey = "fakeApiKey"
        val expectedMovies = listOf(
            Movie("2", "Movie 2",
                "2022-01-01", 10.0,
                "Description 1",123,"url1","asd",100,listGenres)
        )
            Movie("1", "Movie 1",
                "2022-01-01", 10.0,
                "Description 1",123,"url1","asd",100,listGenres)

        // Define o comportamento do mock
        coEvery { mockRepository.getMorePopularMovies(apiKey) } returns expectedMovies

        // Act
        val result = useCase(apiKey) // Chama o método invoke

        // Assert
        assertEquals(expectedMovies, result) // Verifica se o resultado é o esperado
    }

    @Test
    fun `test invoke should return empty list when repository returns empty list`() = runBlocking {
        // Arrange
        val mockRepository = mockk<MovieRepository>() // Mock do MovieRepository
        val useCase = GetMorePopularMoviesUseCase(mockRepository)

        val apiKey = "fakeApiKey"
        val expectedMovies = emptyList<Movie>()

        // Define o comportamento do mock
        coEvery { mockRepository.getMorePopularMovies(apiKey) } returns expectedMovies

        // Act
        val result = useCase(apiKey) // Chama o método invoke

        // Assert
        assertEquals(expectedMovies, result) // Verifica se o resultado é o esperado
    }
}