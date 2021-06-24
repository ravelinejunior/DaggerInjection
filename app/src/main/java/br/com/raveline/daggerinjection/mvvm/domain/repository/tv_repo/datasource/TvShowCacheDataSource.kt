package br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource

import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShows: List<TvShow>)
}