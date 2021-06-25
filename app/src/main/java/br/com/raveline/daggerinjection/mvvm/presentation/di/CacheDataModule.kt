package br.com.raveline.daggerinjection.mvvm.presentation.di

import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistsCacheDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource_impl.ArtistCacheDataSourceImpl
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieCacheDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource_impl.MovieCacheDataSourceImpl
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowCacheDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource_impl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistsCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }
}