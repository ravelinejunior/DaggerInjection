package br.com.raveline.daggerinjection.mvvm.presentation.artist.artist_viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase.GetArtistsUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase.UpdateArtistsUseCase

class ArtistsViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }
}