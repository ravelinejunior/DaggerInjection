package br.com.raveline.daggerinjection.mvvm.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArtists(artists: List<Artist>)

    @Query("DELETE FROM artist_tb")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM ARTIST_TB")
    suspend fun getAllArtists(): List<Artist>

    @Query("SELECT * FROM ARTIST_TB WHERE ID = :id")
    suspend fun getArtist(id: Int): Artist
}