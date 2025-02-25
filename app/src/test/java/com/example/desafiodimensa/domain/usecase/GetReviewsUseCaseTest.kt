package com.example.desafiodimensa.domain.usecase

import com.example.desafiodimensa.data.model.Review
import com.example.desafiodimensa.domain.repository.ReviewRepository
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.testng.annotations.Test

@Test
fun `test invoke should return list of reviews`() = runBlocking {
    // Arrange
    val mockRepository = mockk<ReviewRepository>()
    val useCase = GetReviewsUseCase(mockRepository)

    val movieId = 1
    val apiKey = "fakeApiKey"
    val expectedReviews = listOf(
        Review(
            author = "Author 1",
            content = "This is a great movie!",
        ),
        Review(
            author = "Author 2",
            content = "I loved this movie!",
        )
    )

    // Define o comportamento do mock
    coEvery { mockRepository.getReviews(movieId, apiKey) } returns expectedReviews

    // Act
    val result = useCase(movieId, apiKey) // Chama o método invoke

    // Assert
    assertEquals(expectedReviews, result) // Verifica se o resultado é o esperado
}

@Test
fun `test invoke should return empty list when repository returns empty list`() = runBlocking {
    // Arrange
    val mockRepository = mockk<ReviewRepository>() // Mock do ReviewRepository
    val useCase = GetReviewsUseCase(mockRepository)

    val movieId = 1
    val apiKey = "fakeApiKey"
    val expectedReviews = emptyList<Review>()

    coEvery { mockRepository.getReviews(movieId, apiKey) } returns expectedReviews

    // Act
    val result = useCase(movieId, apiKey) // Chama o método invoke

    // Assert
    assertEquals(expectedReviews, result) // Verifica se o resultado é o esperado
}
