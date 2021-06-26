package br.com.raveline.daggerinjection.mvvm.presentation.artist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.com.raveline.daggerinjection.R
import br.com.raveline.daggerinjection.databinding.ActivityArtistBinding
import br.com.raveline.daggerinjection.mvvm.presentation.artist.artist_viewmodel.ArtistViewModel
import br.com.raveline.daggerinjection.mvvm.presentation.artist.artist_viewmodel.ArtistsViewModelFactory
import br.com.raveline.daggerinjection.mvvm.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistsViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)
    }
}