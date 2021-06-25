package br.com.raveline.daggerinjection.mvvm.presentation.di

import br.com.raveline.daggerinjection.mvvm.data.api.TmdService
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistRemoteDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource_impl.ArtistRemoteDataSourceImpl
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieRemoteDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource_impl.MovieRemoteDataSourceImpl
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowRemoteDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource_impl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {


    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdService: TmdService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(tmdService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdService: TmdService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(tmdService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowDataSource(tmdService: TmdService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(tmdService, apiKey)
    }
}