package br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource

import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}