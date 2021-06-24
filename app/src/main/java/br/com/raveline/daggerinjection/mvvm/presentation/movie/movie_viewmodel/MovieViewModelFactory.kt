package br.com.raveline.daggerinjection.mvvm.presentation.movie.movie_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.GetMoviesUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}