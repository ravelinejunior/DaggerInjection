package br.com.raveline.daggerinjection.dagger.modules

import android.util.Log
import br.com.raveline.daggerinjection.dagger.model.MemoryCard
import dagger.Module
import dagger.Provides


@Module
class MemoryCardModule(val memorySize:Int) {

    @Provides
    fun providesMemoryCard(): MemoryCard {
        Log.i("MYTAG", "Size of memory is $memorySize")
        return MemoryCard()
    }
}