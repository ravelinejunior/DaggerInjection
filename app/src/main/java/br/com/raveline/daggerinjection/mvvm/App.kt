package br.com.raveline.daggerinjection.mvvm

import android.app.Application
import br.com.raveline.daggerinjection.BuildConfig
import br.com.raveline.daggerinjection.mvvm.presentation.di.Injector
import br.com.raveline.daggerinjection.mvvm.presentation.di.artist.ArtistSubComponent
import br.com.raveline.daggerinjection.mvvm.presentation.di.core.*
import br.com.raveline.daggerinjection.mvvm.presentation.di.movie.MovieSubComponent
import br.com.raveline.daggerinjection.mvvm.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent =
        appComponent.artistSubComponent().create()

    override fun createTvShowSubComponent(): TvShowSubComponent =
        appComponent.tvShowSubComponent().create()
}