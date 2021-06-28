package br.com.raveline.daggerinjection.mvvm.data.api

import br.com.raveline.daggerinjection.mvvm.data.model.movie.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TesteService {
    @GET("movie/popular")
     fun getCallMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Call<MovieList>
}