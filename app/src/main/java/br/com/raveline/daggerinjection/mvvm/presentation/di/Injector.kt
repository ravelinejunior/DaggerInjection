package br.com.raveline.daggerinjection.mvvm.presentation.di

import br.com.raveline.daggerinjection.mvvm.presentation.di.artist.ArtistSubComponent
import br.com.raveline.daggerinjection.mvvm.presentation.di.movie.MovieSubComponent
import br.com.raveline.daggerinjection.mvvm.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createArtistSubComponent():ArtistSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
}