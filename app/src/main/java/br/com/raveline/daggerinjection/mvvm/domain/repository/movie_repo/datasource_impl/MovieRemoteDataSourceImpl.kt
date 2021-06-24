package br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource_impl

import br.com.raveline.daggerinjection.mvvm.data.api.TmdService
import br.com.raveline.daggerinjection.mvvm.data.model.movie.MovieList
import br.com.raveline.daggerinjection.mvvm.domain.repository.movie_repo.datasource.MovieRemoteDataSource
import br.com.raveline.daggerinjection.mvvm.utils.language
import br.com.raveline.daggerinjection.mvvm.utils.page
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TmdService,
    private val apiKey: String
) :
    MovieRemoteDataSource {
    override suspend fun getMoviesFromRemote(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey, language, page)
    }
}