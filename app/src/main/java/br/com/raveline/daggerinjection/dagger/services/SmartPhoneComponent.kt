package br.com.raveline.daggerinjection.dagger.services

import br.com.raveline.daggerinjection.dagger.MainActivity
import br.com.raveline.daggerinjection.dagger.modules.MemoryCardModule
import br.com.raveline.daggerinjection.dagger.modules.NickelBattertModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class, NickelBattertModule::class])
interface SmartPhoneComponent {
    fun inject(mainActivity: MainActivity)
}