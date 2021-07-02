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

    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromApi()
        movieLocalDataSource.clearMoviesFromDb()
        movieLocalDataSource.saveMoviesToDb(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromApi(): List<Movie> {

        val movies = movieRemoteDataSource.getMoviesFromRemote().body()?.movies as ArrayList<Movie>
        Log.e("MoviesRepo", movies.toString())

        return movies
    }

    suspend fun getMoviesFromDatabase(): List<Movie> {
        lateinit var movieList: List<Movie>

        return try {
            movieList = movieLocalDataSource.getMoviesFromDatabase()
            if (movieList.isNotEmpty()) movieList
            else {
                movieList = getMoviesFromApi()
                movieLocalDataSource.saveMoviesToDb(movieList)
                movieList
            }
        } catch (e: Exception) {
            Log.e("MoviesRepo", e.message.toString())
            e.printStackTrace()
            ArrayList()
        }




    }

    suspend fun getMoviesFromCache(): List<Movie> {
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