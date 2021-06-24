package br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource

import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDatabase(): List<Artist>?
    suspend fun saveArtistsToDatabase(artists: List<Artist>)
    suspend fun deleteArtistsFromDatabase()
}