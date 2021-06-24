package br.com.raveline.daggerinjection.mvvm.domain.usecase.tv_usecase

import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.TvRepository

class UpdateTvShowUseCase(private val tvRepository: TvRepository) {
    suspend fun executeUpdate(): List<TvShow>? = tvRepository.updateTvShows()
}