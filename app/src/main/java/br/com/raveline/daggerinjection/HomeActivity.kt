package br.com.raveline.daggerinjection

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.TEXT_ALIGNMENT_CENTER
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.raveline.daggerinjection.databinding.ActivityHomeBinding
import br.com.raveline.daggerinjection.mvvm.presentation.artist.ArtistActivity
import br.com.raveline.daggerinjection.mvvm.presentation.movie.MovieActivity
import br.com.raveline.daggerinjection.mvvm.presentation.tv.TvShowActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var dataBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        dataBinding.toolbarMvvm.title = "Mvvm Default Project"
        dataBinding.toolbarMvvm.textAlignment = TEXT_ALIGNMENT_CENTER

        setSupportActionBar(dataBinding.toolbarMvvm)
        dataBinding.apply {
            btnArtistId.setOnClickListener(this@HomeActivity)
            btnMoviesId.setOnClickListener(this@HomeActivity)
            btnTvShowId.setOnClickListener(this@HomeActivity)
        }


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            dataBinding.btnArtistId.id -> {
                val intent = Intent(this, ArtistActivity::class.java)
                startActivity(intent)
            }

            dataBinding.btnMoviesId.id -> {
                val intent = Intent(this, MovieActivity::class.java)
                startActivity(intent)
            }

            dataBinding.btnTvShowId.id -> {
                val intent = Intent(this, TvShowActivity::class.java)
                startActivity(intent)
            }
        }
    }
}