package br.com.raveline.daggerinjection.mvvm.presentation.tv.tv_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.raveline.daggerinjection.mvvm.domain.usecase.tv_usecase.GetTvShowUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.tv_usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModel() {
    fun getTvShows() = liveData {
        val tvShows = getTvShowUseCase.execute()
        tvShows?.let { emit(it) }
    }

    fun updateTvShows() = liveData {
        val tvShows = updateTvShowUseCase.executeUpdate()
        tvShows?.let { emit(it) }
    }
}