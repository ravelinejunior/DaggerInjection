package br.com.raveline.daggerinjection.mvvm.presentation.artist.artist_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist
import br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase.GetArtistsUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {
    fun getArtists() = liveData<List<Artist>> {
        val artists = getArtistsUseCase.execute()
        artists?.let { emit(it) }
    }

    fun updateArtists() = liveData<List<Artist>> {
        val artists = updateArtistsUseCase.executeUpdate()
        artists?.let { emit(it) }
    }
}