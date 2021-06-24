package br.com.raveline.daggerinjection.dagger.model

import android.util.Log
import br.com.raveline.daggerinjection.dagger.model.interfaces.Battery
import javax.inject.Inject

class NickelCadmiumBattery @Inject constructor(): Battery {
    override fun getPower() {
        Log.i("MYTAG","Get Power from NickelCadmiumBattery")
    }
}