package br.com.raveline.daggerinjection.mvvm.presentation.di.core

import br.com.raveline.daggerinjection.mvvm.presentation.di.artist.ArtistSubComponent
import br.com.raveline.daggerinjection.mvvm.presentation.di.movie.MovieSubComponent
import br.com.raveline.daggerinjection.mvvm.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheDataModule::class,
        DatabaseModule::class,
        LocalDataModule::class,
        NetModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
    ]
)
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}