package br.com.raveline.daggerinjection.mvvm.presentation.di.movie

import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.GetMoviesUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.UpdateMoviesUseCase
import br.com.raveline.daggerinjection.mvvm.presentation.movie.movie_viewmodel.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase, updateMoviesUseCase
        )
    }

}