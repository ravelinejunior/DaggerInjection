package br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo

import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?
}