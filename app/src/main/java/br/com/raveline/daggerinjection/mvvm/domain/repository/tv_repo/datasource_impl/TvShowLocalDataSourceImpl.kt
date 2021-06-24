package br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource_impl

import br.com.raveline.daggerinjection.mvvm.data.db.dao.TvShowDao
import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow
import br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDatabase(): List<TvShow> = tvShowDao.getAllTvShows()

    override suspend fun saveTvShowToDatabase(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.insertTvShow(tvShows)
        }
    }

    override suspend fun deleteTvShowFromDatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}