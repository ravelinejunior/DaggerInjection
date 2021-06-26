package br.com.raveline.daggerinjection.mvvm.presentation.di.core

import android.content.Context
import androidx.room.Room
import br.com.raveline.daggerinjection.mvvm.data.db.TmdDatabase
import br.com.raveline.daggerinjection.mvvm.data.db.dao.ArtistDao
import br.com.raveline.daggerinjection.mvvm.data.db.dao.MovieDao
import br.com.raveline.daggerinjection.mvvm.data.db.dao.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TmdDatabase {
        return Room.databaseBuilder(context, TmdDatabase::class.java, "tmdclient").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdDatabase: TmdDatabase): MovieDao {
        return tmdDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistsDao(tmdDatabase: TmdDatabase): ArtistDao {
        return tmdDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdDatabase: TmdDatabase): TvShowDao {
        return tmdDatabase.tvShowDao()
    }

}