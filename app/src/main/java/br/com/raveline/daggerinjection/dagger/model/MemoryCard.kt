package br.com.raveline.daggerinjection.dagger.model
import android.util.Log
import javax.inject.Inject

class MemoryCard{
    init {
        Log.i("MYTAG","Memory Card Constructed")
    }

    fun getSpaceAvailablity(){
        Log.i("MYTAG","Memory space available")
    }
}