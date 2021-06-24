package br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase

import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun executeUpdate():List<Movie>? = movieRepository.updateMovies()
}