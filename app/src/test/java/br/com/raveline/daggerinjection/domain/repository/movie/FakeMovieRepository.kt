package br.com.raveline.daggerinjection.domain.repository.movie

import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.MovieRepository

class FakeMovieRepository : MovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        val moviesList = listOf<Movie>(
            Movie(
                true, "path", 1, "Loki O ninja", "O ninja Loki", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 10.5, 5
            ),
            Movie(
                false, "path", 2, "Loki O Shinobi", "O Shinobi Loki", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 100.5, 5
            ),
            Movie(
                true, "path", 3, "Thor O Nordico", "O THor Loki", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 10.55, 5
            ),
            Movie(
                false, "path", 4, "Naturo O ninja", "O ninja Naruto", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 10.53, 5
            ),
            Movie(
                true, "path", 5, "Ricky O ninja", "O ninja Morty", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 109.5, 5
            )
        )

        movies.addAll(moviesList)
    }

    override suspend fun getMovies(): List<Movie>? = movies

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        val moviesList = listOf<Movie>(
            Movie(
                true, "path", 6, "Loki O ninja", "O ninja Loki", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 10.5, 5
            ),
            Movie(
                false, "path", 7, "Loki O Shinobi", "O Shinobi Loki", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 100.5, 5
            ),
            Movie(
                true, "path", 8, "Thor O Nordico", "O THor Loki", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 10.55, 5
            ),
            Movie(
                false, "path", 9, "Naturo O ninja", "O ninja Naruto", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 10.53, 5
            ),
            Movie(
                true, "path", 10, "Ricky O ninja", "O ninja Morty", "ahsdljashndlksajdla",
                100.0, "posterPath,", "10/10/2069", "My title", true, 109.5, 5
            )
        )

        movies.addAll(moviesList)
        return movies

    }
}