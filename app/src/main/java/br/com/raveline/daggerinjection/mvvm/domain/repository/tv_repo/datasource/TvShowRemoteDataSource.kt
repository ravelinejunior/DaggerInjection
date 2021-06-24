package br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource

import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShowFromApi():Response<TvShowList>?
}