package br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo

import android.util.Log
import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistLocalDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistRemoteDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistsCacheDataSource

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistsCacheDataSource: ArtistsCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist> = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist> {
        val newListOfArtist = getArtistsFromApi()
        artistLocalDataSource.deleteArtistsFromDatabase()
        artistLocalDataSource.saveArtistsToDatabase(newListOfArtist)
        artistsCacheDataSource.saveArtistsOnCache(newListOfArtist)
        return newListOfArtist
    }

    private suspend fun getArtistsFromApi(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtistsFromApi()
            val body = response?.body()
            if (body != null) {
                artists = body.artists
            }
        } catch (e: Exception) {
            Log.e("ArtistRepo", e.message.toString())
            e.printStackTrace()
        }

        return artists
    }

    private suspend fun getArtistsFromDatabase(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            artists = artistLocalDataSource.getArtistsFromDatabase()!!

        } catch (e: Exception) {
            Log.e("ArtistRepo", e.message.toString())
            e.printStackTrace()
        }

        if (artists.isNotEmpty()) return artists
        else {
            artists = getArtistsFromApi()
            artistLocalDataSource.saveArtistsToDatabase(artists)
        }

        return artists

    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artists: List<Artist>

        try {
            artists = artistsCacheDataSource.getArtistsFromCache()
        } catch (e: Exception) {
            Log.e("ArtistRepo", e.message.toString())
            e.printStackTrace()
        }

        if (!artists.isNullOrEmpty()) {
            return artists
        } else {
            artists = getArtistsFromDatabase()
            artistsCacheDataSource.saveArtistsOnCache(artists)
        }

        return artists
    }
}