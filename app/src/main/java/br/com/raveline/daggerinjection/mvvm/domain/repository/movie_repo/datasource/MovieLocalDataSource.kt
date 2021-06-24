package br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource

import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDatabase(): List<Movie>
    suspend fun saveMoviesToDb(movies: List<Movie>)
    suspend fun clearMoviesFromDb()
}