package br.com.raveline.daggerinjection.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.raveline.daggerinjection.R
import br.com.raveline.daggerinjection.dagger.application.SmartPhoneApplication
import br.com.raveline.daggerinjection.dagger.model.SmartPhone
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as SmartPhoneApplication).smartPhoneComponent.inject(this)
    }

    init {
        //o smartphone ja foi injetado dentro da classe main.
        /*    DaggerSmartPhoneComponent.create().inject(this)
            smartPhone.makeACallWithRecording()*/


    }
}