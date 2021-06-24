package br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource_impl

import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> = tvShowList

    override suspend fun saveTvShowToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}