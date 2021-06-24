package br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource_impl

import br.com.raveline.daggerinjection.mvvm.data.db.dao.ArtistDao
import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDatabase(): List<Artist> = artistDao.getAllArtists()


    override suspend fun saveArtistsToDatabase(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.insertArtists(artists)
        }
    }

    override suspend fun deleteArtistsFromDatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}