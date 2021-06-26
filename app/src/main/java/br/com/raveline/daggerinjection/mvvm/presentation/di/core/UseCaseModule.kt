package br.com.raveline.daggerinjection.mvvm.presentation.di.core

import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.ArtistRepository
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.MovieRepository
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.TvRepository
import br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase.GetArtistsUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.artist_usecase.UpdateArtistsUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.GetMoviesUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.movie_usecase.UpdateMoviesUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.tv_usecase.GetTvShowUseCase
import br.com.raveline.daggerinjection.mvvm.domain.usecase.tv_usecase.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvRepository): GetTvShowUseCase {
        return GetTvShowUseCase(tvShowRepository)
    }


    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvRepository: TvRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvRepository)
    }
}