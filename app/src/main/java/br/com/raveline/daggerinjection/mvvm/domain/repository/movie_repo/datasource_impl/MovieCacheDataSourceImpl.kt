package br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource_impl

import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> = movieList

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}