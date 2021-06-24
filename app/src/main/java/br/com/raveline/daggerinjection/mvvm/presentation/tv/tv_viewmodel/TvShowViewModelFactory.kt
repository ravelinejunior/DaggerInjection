package br.com.raveline.daggerinjection.mvvm.presentation.tv.tv_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.raveline.daggerinjection.mvvm.domain.usecase.tv_usecase.GetTvShowUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.tv_usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}