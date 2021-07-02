package br.com.raveline.daggerinjection.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.raveline.daggerinjection.mvvm.data.db.TmdDatabase
import br.com.raveline.daggerinjection.mvvm.data.db.dao.MovieDao
import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dao: MovieDao
    private lateinit var database: TmdDatabase

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TmdDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    @After //chamado apos teste acabar para fechar banco de dados
    fun tearDown() {
        database.close()
    }

    @Test
    fun saveMovieTest() = runBlocking {
        val movies = listOf<Movie>(
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

        dao.insertMovieDao(movies)

        val allMovies = dao.getAllMovies()

        Truth.assertThat(allMovies).isEqualTo(movies)



    }

    @Test
    fun deleteMoviesTest(): Unit = runBlocking {
        val movies = listOf<Movie>(
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

        dao.insertMovieDao(movies)
        dao.deleteAllMovies()
        val moviesResult = dao.getAllMovies()
        Truth.assertThat(moviesResult).isEmpty()
    }



}