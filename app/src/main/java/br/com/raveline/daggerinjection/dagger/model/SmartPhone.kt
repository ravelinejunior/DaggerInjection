package br.com.raveline.daggerinjection.dagger.model

import android.util.Log
import br.com.raveline.daggerinjection.dagger.model.interfaces.Battery
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmartPhone @Inject constructor (private val battery: Battery, private val simCard: SIMCard, private val memoryCard: MemoryCard) {

    init {
        Log.i("MYTAG", "SmartPhone Constructed")
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailablity()
    }

    fun makeACallWithRecording() {
        Log.i("MYTAG", "Calling.....")
    }
}