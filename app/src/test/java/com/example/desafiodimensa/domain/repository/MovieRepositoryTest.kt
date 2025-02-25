package com.example.desafiodimensa.domain.repository

import com.example.desafiodimensa.data.model.DetailsMovie
import com.example.desafiodimensa.data.model.Genre
import com.example.desafiodimensa.data.model.Movie
import com.example.desafiodimensa.data.model.MovieResponse
import com.example.desafiodimensa.data.remote.TMDbApiService
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import io.mockk.coEvery


@ExperimentalCoroutinesApi
class MovieRepositoryTest {

    private val apiService: TMDbApiService = mockk()
    private val repository = MovieRepository(apiService)

    @Test
    fun `getSimilarMovies should return list of movies`() = runBlocking {
        // Arrange
        val movieId = 123
        val listGenres = listOf(Genre("1"), Genre("2"), Genre("3"))
        val apiKey = "test_api_key"
        val mockResponse = MovieResponse(
            results = listOf(
                Movie(
                    id = 1,
                    title = "Test Movie",
                    overview = "Test overview",
                    posterPath = "test_poster_path",
                    releaseDate = "2022-01-01",
                    voteAverage = 7.5,
                    backdropPath = "test_backdrop_path",
                    language = "en",
                    runtime = 100,
                    genres = listGenres
                )
            )
        )

        coEvery { apiService.getSimilarMovies(movieId, apiKey) } returns mockResponse

        // Act
        val result = repository.getSimilarMovies(movieId, apiKey)

        // Assert
        assertEquals(mockResponse.results, result)
    }

    @Test
    fun `getNowPlayingMovies should return list of movies`() = runBlocking {
        // Arrange
        val apiKey = "test_api_key"
        val listGenres = listOf(Genre("1"), Genre("2"), Genre("3"))
        val mockResponse = MovieResponse(
            results = listOf(
                Movie(
                    id = 1,
                    title = "Test Movie",
                    overview = "Test overview",
                    posterPath = "test_poster_path",
                    releaseDate = "2022-01-01",
                    voteAverage = 7.5,
                    backdropPath = "test_backdrop_path",
                    language = "en",
                    runtime = 100,
                    genres = listGenres
                )
            )
        )

        coEvery { apiService.getNowPlayingMovies(apiKey) } returns mockResponse

        // Act
        val result = repository.getNowPlayingMovies(apiKey)

        // Assert
        assertEquals(mockResponse.results, result)
    }

    @Test
    fun `getComingSoonMovies should return list of movies`() = runBlocking {
        // Arrange
        val apiKey = "test_api_key"
        val listGenres = listOf(Genre("1"), Genre("2"), Genre("3"))

        val mockResponse = MovieResponse(
            results = listOf(
                Movie(
                    id = 1,
                    title = "Test Movie",
                    overview = "Test overview",
                    posterPath = "test_poster_path",
                    releaseDate = "2022-01-01",
                    voteAverage = 7.5,
                    backdropPath = "test_backdrop_path",
                    language = "en",
                    runtime = 100,
                    genres = listGenres
                )
            )
        )

        coEvery { apiService.getComingSoonMovies(apiKey) } returns mockResponse

        // Act
        val result = repository.getComingSoonMovies(apiKey)

        // Assert
        assertEquals(mockResponse.results, result)
    }

    @Test
    fun `getMorePopularMovies should return list of movies`() = runBlocking {
        // Arrange
        val apiKey = "test_api_key"
        val listGenres = listOf(Genre("1"), Genre("2"), Genre("3"))

        val mockResponse = MovieResponse(
            results = listOf(
                Movie(
                    id = 1,
                    title = "Test Movie",
                    overview = "Test overview",
                    posterPath = "test_poster_path",
                    releaseDate = "2022-01-01",
                    voteAverage = 7.5,
                    backdropPath = "test_backdrop_path",
                    language = "en",
                    runtime = 100,
                    genres = listGenres
                )
            )
        )

        coEvery { apiService.getMorePopularMovies(apiKey) } returns mockResponse

        // Act
        val result = repository.getMorePopularMovies(apiKey)

        // Assert
        assertEquals(mockResponse.results, result)
    }

    @Test
    fun `getTopRatedMovies should return list of movies`() = runBlocking {
        // Arrange
        val apiKey = "test_api_key"
        val listGenres = listOf(Genre("1"), Genre("2"), Genre("3"))

        val mockResponse = MovieResponse(
            results = listOf(
                Movie(
                    id = 1,
                    title = "Test Movie",
                    overview = "Test overview",
                    posterPath = "test_poster_path",
                    releaseDate = "2022-01-01",
                    voteAverage = 7.5,
                    backdropPath = "test_backdrop_path",
                    language = "en",
                    runtime = 100,
                    genres = listGenres
                )
            )
        )

        coEvery { apiService.getTopRatedMovies(apiKey) } returns mockResponse

        // Act
        val result = repository.getTopRatedMovies(apiKey)

        // Assert
        assertEquals(mockResponse.results, result)
    }

    @Test
    fun `getDetailsMovie should return list of movies`() = runBlocking {
        // Arrange
        val movieId = 123
        val listGenres = listOf(Genre("1"), Genre("2"), Genre("3"))
        val apiKey = "test_api_key"
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

        coEvery { apiService.getMovieDetail(movieId, apiKey) } returns expectedDetailsMovie

        // Act
        val result = repository.getDetailsMovie(movieId, apiKey)

        // Assert
        assertEquals(expectedDetailsMovie, result)
    }
}