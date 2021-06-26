package br.com.raveline.daggerinjection.mvvm.presentation.di.tvshow

import br.com.raveline.daggerinjection.mvvm.domain.usecase.tv_usecase.GetTvShowUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.tv_usecase.UpdateTvShowUseCase
import br.com.raveline.daggerinjection.mvvm.presentation.tv.tv_viewmodel.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowUseCase,
        updateTvShowsUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase, updateTvShowsUseCase
        )
    }

}