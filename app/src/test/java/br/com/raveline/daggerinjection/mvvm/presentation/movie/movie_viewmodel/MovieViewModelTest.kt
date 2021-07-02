package br.com.raveline.daggerinjection.mvvm.presentation.movie.movie_viewmodel

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.raveline.daggerinjection.domain.repository.movie.FakeMovieRepository
import br.com.raveline.daggerinjection.getOrAwaitValue
import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie
import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.GetMoviesUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.UpdateMoviesUseCase
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    //faz os testes serem gerados na mesma thread
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel


    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList() {
        val movieList = mutableListOf<Movie>()

        val movies = listOf(
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

        movieList.addAll(movies)

        val currentMovieList =
            viewModel.getMovies().getOrAwaitValue() // função altera de live data para data normal

        assertThat(currentMovieList).isEqualTo(movies)

    }

    @Test
    fun updateMovies_returnsCurrentList() {
        val movieList = mutableListOf<Movie>()

        val movies = listOf(
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

        movieList.addAll(movies)

        val currentMovieList = viewModel.updateNovies().getOrAwaitValue()

        assertThat(currentMovieList).isEqualTo(movies)

    }
}