package br.com.raveline.daggerinjection.mvvm.presentation.movie.movie_viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie
import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.GetMoviesUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {
    fun getMovies(): LiveData<List<Movie>> = liveData {
        val movieList = getMoviesUseCase.execute()
        movieList?.let { emit(it) }
    }

    fun updateNovies() = liveData<List<Movie>> {
        val movieList = updateMoviesUseCase.executeUpdate()
        movieList?.let { emit(it) }
    }
}