package br.com.raveline.daggerinjection.dagger.application

import android.app.Application
import br.com.raveline.daggerinjection.dagger.modules.MemoryCardModule
import br.com.raveline.daggerinjection.dagger.services.DaggerSmartPhoneComponent

import br.com.raveline.daggerinjection.dagger.services.SmartPhoneComponent

class SmartPhoneApplication : Application() {
    lateinit var smartPhoneComponent: SmartPhoneComponent
    override fun onCreate() {
        super.onCreate()
        smartPhoneComponent = initDagger()
    }

    private fun initDagger(): SmartPhoneComponent = DaggerSmartPhoneComponent.builder()
        .memoryCardModule(MemoryCardModule(1000))
        .build()
}