package br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource_impl

import br.com.raveline.daggerinjection.mvvm.data.api.TmdService
import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShowList
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowRemoteDataSource
import br.com.raveline.daggerinjection.mvvm.utils.language
import br.com.raveline.daggerinjection.mvvm.utils.page
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdService: TmdService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShowFromApi(): Response<TvShowList> =
        tmdService.getPopularTvShow(apiKey, language, page)
}