package br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo

import android.util.Log
import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieCacheDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieLocalDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieRemoteDataSource

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie> = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie> {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearMoviesFromDb()
        movieLocalDataSource.saveMoviesToDb(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDataSource.getMoviesFromRemote()
            val body = response?.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            Log.e("MoviesRepo", e.message.toString())
            e.printStackTrace()
        }

        return movieList
    }

    private suspend fun getMoviesFromDatabase(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            movieList = movieLocalDataSource.getMoviesFromDatabase()
        } catch (e: Exception) {
            Log.e("MoviesRepo", e.message.toString())
            e.printStackTrace()
        }

        if (movieList.isNotEmpty()) return movieList
        else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDb(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movies: List<Movie>

        try {
            movies = movieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            Log.e("MoviesRepo", e.message.toString())
            e.printStackTrace()
        }

        if (movies.isNotEmpty()) return movies
        else {
            movies = getMoviesFromDatabase()
            movieCacheDataSource.saveMoviesToCache(movies)
        }

        return movies
    }

}