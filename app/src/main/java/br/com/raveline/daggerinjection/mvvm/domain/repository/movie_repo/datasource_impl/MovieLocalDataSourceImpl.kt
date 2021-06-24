package br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource_impl

import br.com.raveline.daggerinjection.mvvm.data.db.dao.MovieDao
import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(
    private val movieDao: MovieDao
) : MovieLocalDataSource {
    override suspend fun getMoviesFromDatabase(): List<Movie> {
        return movieDao.getAllMovies();
    }

    override suspend fun saveMoviesToDb(movies: List<Movie>) {
        //setar coroutines para rodar essa função em uma thread
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.insertMovieDao(movies)
        }
    }

    override suspend fun clearMoviesFromDb() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}