package br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource

import br.com.raveline.daggerinjection.mvvm.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMoviesFromRemote(): Response<MovieList>?
}