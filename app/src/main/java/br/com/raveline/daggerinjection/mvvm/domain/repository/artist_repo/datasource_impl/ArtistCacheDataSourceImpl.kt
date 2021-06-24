package br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource_impl

import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistsCacheDataSource

class ArtistCacheDataSourceImpl : ArtistsCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistsFromCache(): List<Artist> = artistList

    override suspend fun saveArtistsOnCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }

}