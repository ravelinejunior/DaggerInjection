package br.com.raveline.daggerinjection.mvvm.data.db.dao

import androidx.room.*
import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDao(movies: List<Movie>)

    @Delete
    suspend fun deleteMovieDao(movie: Movie)

    @Query("DELETE FROM MOVIE_TB")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM MOVIE_TB ORDER BY releaseDate DESC")
    suspend fun getAllMovies(): List<Movie>

    @Query("SELECT * FROM MOVIE_TB WHERE ID = :id")
    suspend fun getSelectedMovie(id: Int): Movie

}