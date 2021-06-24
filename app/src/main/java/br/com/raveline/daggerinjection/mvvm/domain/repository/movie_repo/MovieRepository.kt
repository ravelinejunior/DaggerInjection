package br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo

import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}