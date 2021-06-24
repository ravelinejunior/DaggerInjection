package br.com.raveline.daggerinjection.mvvm.data.api

import br.com.raveline.daggerinjection.mvvm.data.model.artist.PeopleList
import br.com.raveline.daggerinjection.mvvm.data.model.movie.MovieList
import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShow(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularPeople(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int,
    ): Response<PeopleList>

}