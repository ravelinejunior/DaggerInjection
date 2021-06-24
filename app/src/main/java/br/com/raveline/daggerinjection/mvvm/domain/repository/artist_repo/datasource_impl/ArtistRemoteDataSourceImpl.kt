package br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource_impl

import br.com.raveline.daggerinjection.mvvm.data.api.TmdService
import br.com.raveline.daggerinjection.mvvm.data.model.artist.PeopleList
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistRemoteDataSource
import br.com.raveline.daggerinjection.mvvm.utils.language
import br.com.raveline.daggerinjection.mvvm.utils.page
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TmdService,
    private val apiKey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtistsFromApi(): Response<PeopleList> =
        tmdbService.getPopularPeople(
        apiKey, language, page
    )
}