package br.com.raveline.daggerinjection.mvvm.presentation.artist

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.raveline.daggerinjection.R
import br.com.raveline.daggerinjection.databinding.ActivityArtistBinding
import br.com.raveline.daggerinjection.mvvm.presentation.artist.adapter.ArtistAdapter
import br.com.raveline.daggerinjection.mvvm.presentation.artist.artist_viewmodel.ArtistViewModel
import br.com.raveline.daggerinjection.mvvm.presentation.artist.artist_viewmodel.ArtistsViewModelFactory
import br.com.raveline.daggerinjection.mvvm.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ArtistsViewModelFactory
    private lateinit var artistViewModel: ArtistViewModel
    private lateinit var binding: ActivityArtistBinding
    private lateinit var artistAdapter: ArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

        (application as Injector).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this, factory).get(ArtistViewModel::class.java)

        artistAdapter = ArtistAdapter()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerViewArtist.apply {
            layoutManager = LinearLayoutManager(this@ArtistActivity)
            setHasFixedSize(true)
            adapter = artistAdapter
            displayArtistData()
        }
    }

    private fun displayArtistData() {
        binding.progressBarArtist.visibility = VISIBLE

        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, { artists ->
            if (artists != null) {
                artistAdapter.setList(artists)
                artistAdapter.notifyDataSetChanged()
                binding.progressBarArtist.visibility = GONE
            } else {
                Toast.makeText(this@ArtistActivity, "No data founded!", Toast.LENGTH_SHORT).show()
                binding.progressBarArtist.visibility = GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_update, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_update_action -> {
                updateArtistData()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }

    private fun updateArtistData() {
        binding.progressBarArtist.visibility = VISIBLE
        val responseLiveData = artistViewModel.updateArtists()
        responseLiveData.observe(this@ArtistActivity, { artists ->
            if (artists != null) {
                artistAdapter.setList(artists)
                artistAdapter.notifyDataSetChanged()
                binding.progressBarArtist.visibility = GONE
            } else {
                Toast.makeText(
                    this@ArtistActivity,
                    "No data to update!",
                    Toast.LENGTH_SHORT
                ).show()
                binding.progressBarArtist.visibility = GONE
            }
        })
    }
}