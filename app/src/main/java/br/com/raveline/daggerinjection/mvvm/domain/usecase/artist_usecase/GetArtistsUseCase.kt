package br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase

import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}