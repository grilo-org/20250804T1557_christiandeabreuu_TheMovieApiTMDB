package com.example.desafiodimensa.domain.repository

import com.example.desafiodimensa.data.model.Review
import com.example.desafiodimensa.data.model.ReviewResponse
import com.example.desafiodimensa.data.remote.TMDbApiService
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ReviewRepositoryUnitTest {

    @Test
    fun `getReviews should return list of reviews`() = runBlocking {
        // Arrange
        val mockApiService = mockk<TMDbApiService>() // Mock do ApiService
        val repository = ReviewRepository(mockApiService)

        val movieId = 123
        val apiKey = "fakeApiKey"
        val expectedReviews = listOf(
            Review(author = "Author 1", content = "Content 1"),
            Review(author = "Author 2", content = "Content 2")
        )
        val mockResponse = ReviewResponse(0,1,expectedReviews,1,1)

        // Define o comportamento do mock
        coEvery { mockApiService.getReviews(movieId, apiKey) } returns mockResponse

        // Act
        val result = repository.getReviews(movieId, apiKey) // Chama a função getReviews

        // Assert
        assertEquals(expectedReviews, result) // Verifica se o resultado é o esperado
    }

    @Test
    fun `getReviews should return empty list when API returns empty list`() = runBlocking {
        // Arrange
        val mockApiService = mockk<TMDbApiService>() // Mock do ApiService
        val repository = ReviewRepository(mockApiService)

        val movieId = 123
        val apiKey = "fakeApiKey"
        val expectedReviews = emptyList<Review>()
        val mockResponse = ReviewResponse(0,1,expectedReviews,1,1)

        // Define o comportamento do mock
        coEvery { mockApiService.getReviews(movieId, apiKey) } returns mockResponse

        // Act
        val result = repository.getReviews(movieId, apiKey) // Chama a função getReviews

        // Assert
        assertEquals(expectedReviews, result) // Verifica se o resultado é o esperado
    }
}
