package br.com.raveline.daggerinjection.mvvm.domain.repository.tv_repo.datasource

import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDatabase():List<TvShow>
    suspend fun saveTvShowToDatabase(tvShows:List<TvShow>)
    suspend fun deleteTvShowFromDatabase()
}