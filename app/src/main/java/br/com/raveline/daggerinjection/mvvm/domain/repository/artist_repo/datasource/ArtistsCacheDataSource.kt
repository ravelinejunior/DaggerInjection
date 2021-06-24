package br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource

import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist

interface ArtistsCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsOnCache(artists: List<Artist>)
}