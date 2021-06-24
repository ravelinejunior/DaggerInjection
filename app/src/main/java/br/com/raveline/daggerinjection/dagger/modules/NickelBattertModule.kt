package br.com.raveline.daggerinjection.dagger.modules

import br.com.raveline.daggerinjection.dagger.model.NickelCadmiumBattery
import br.com.raveline.daggerinjection.dagger.model.interfaces.Battery
import dagger.Binds
import dagger.Module

@Module
abstract class NickelBattertModule {

    @Binds
    abstract fun providesNickelBattery(nickelCadmiumBattery: NickelCadmiumBattery): Battery
}