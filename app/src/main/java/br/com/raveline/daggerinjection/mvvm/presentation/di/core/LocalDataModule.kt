package br.com.raveline.daggerinjection.mvvm.presentation.di.core

import br.com.raveline.daggerinjection.mvvm.data.db.dao.ArtistDao
import br.com.raveline.daggerinjection.mvvm.data.db.dao.MovieDao
import br.com.raveline.daggerinjection.mvvm.data.db.dao.TvShowDao
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistLocalDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource_impl.ArtistLocalDataSourceImpl
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieLocalDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource_impl.MovieLocalDataSourceImpl
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowLocalDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource_impl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule() {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

}