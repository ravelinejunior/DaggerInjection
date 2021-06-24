package br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase

import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun executeUpdate():List<Artist>? = artistRepository.updateArtists()
}