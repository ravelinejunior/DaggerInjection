package br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo

import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow

interface TvRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}