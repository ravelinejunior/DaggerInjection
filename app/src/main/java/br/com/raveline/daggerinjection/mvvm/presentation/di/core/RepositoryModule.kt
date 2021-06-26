package br.com.raveline.daggerinjection.mvvm.presentation.di.core

import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.ArtistRepository
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.ArtistRepositoryImpl
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistLocalDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistRemoteDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.artist_repo.datasource.ArtistsCacheDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.MovieRepository
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.MovieRepositoryImpl
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieCacheDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieLocalDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieRemoteDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.TvRepository
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.TvRepositoryImpl
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowCacheDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowLocalDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistsCacheDataSource: ArtistsCacheDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistRemoteDataSource: ArtistRemoteDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource, artistLocalDataSource, artistsCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowRemoteDataSource: TvShowRemoteDataSource
    ): TvRepository {
        return TvRepositoryImpl(
            tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource
        )
    }
}