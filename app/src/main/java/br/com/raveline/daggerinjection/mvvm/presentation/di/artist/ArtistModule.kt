package br.com.raveline.daggerinjection.mvvm.presentation.di.artist

import br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase.GetArtistsUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase.UpdateArtistsUseCase
import br.com.raveline.daggerinjection.mvvm.presentation.artist.artist_viewmodel.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistsViewModelFactory {
        return ArtistsViewModelFactory(
            getArtistsUseCase, updateArtistsUseCase
        )
    }

}