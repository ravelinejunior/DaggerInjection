package br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource

import br.com.raveline.daggerinjection.mvvm.data.model.artist.PeopleList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtistsFromApi(): Response<PeopleList>?
}