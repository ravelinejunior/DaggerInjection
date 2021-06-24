package br.com.raveline.daggerinjection.mvvm.data.db.dao

import androidx.room.*
import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(tvShows: List<TvShow>)

    @Query("DELETE FROM TVSHOW_TB")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM TVSHOW_TB")
    suspend fun getAllTvShows(): List<TvShow>

    @Query("SELECT * FROM TVSHOW_TB WHERE ID = :id")
    suspend fun getTvShow(id: Int): TvShow

}