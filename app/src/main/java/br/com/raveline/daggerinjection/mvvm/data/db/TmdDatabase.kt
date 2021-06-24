package br.com.raveline.daggerinjection.mvvm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.raveline.daggerinjection.mvvm.data.db.dao.ArtistDao
import br.com.raveline.daggerinjection.mvvm.data.db.dao.MovieDao
import br.com.raveline.daggerinjection.mvvm.data.db.dao.TvShowDao
import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist
import br.com.raveline.daggerinjection.mvvm.data.model.movie.Movie
import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow

@Database(
    entities = [Movie::class, Artist::class, TvShow::class],
    version = 1,
    exportSchema = false
)
abstract class TmdDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}