package br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo

import android.util.Log
import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowCacheDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowLocalDataSource
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowRemoteDataSource

class TvRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvRepository {
    override suspend fun getTvShows(): List<TvShow> = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShowList = getTvShowsFromApi()
        tvShowLocalDataSource.deleteTvShowFromDatabase()
        tvShowLocalDataSource.saveTvShowToDatabase(newTvShowList)
        tvShowCacheDataSource.saveTvShowToCache(newTvShowList)
        return newTvShowList
    }

    private suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var listTvShows: List<TvShow>

        try {
            val response = tvShowRemoteDataSource.getTvShowFromApi()
            val body = response?.body()
            if (body != null) {
                listTvShows = body.tvShows
            }
        } catch (e: Exception) {
            Log.e("TvShowRepo", e.message.toString())
            e.printStackTrace()
        }

        return listTvShows
    }

    private suspend fun getTvShowsFromDatabase(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDatabase()
        } catch (e: Exception) {
            Log.e("TvShowRepo", e.message.toString())
            e.printStackTrace()
        }

        if (tvShowList.isNotEmpty()) return tvShowList
        else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowToDatabase(tvShowList)
        }

        return tvShowList
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDataSource.getTvShowFromCache()
        } catch (e: Exception) {
            Log.e("TvShowRepo", e.message.toString())
            e.printStackTrace()
        }

        if (tvShowList.isNotEmpty()) return tvShowList
        else {
            tvShowList = getTvShowsFromDatabase()
            tvShowCacheDataSource.saveTvShowToCache(tvShowList)
        }

        return tvShowList
    }
}
















