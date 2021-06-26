package br.com.raveline.daggerinjection.mvvm.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import br.com.raveline.daggerinjection.R
import br.com.raveline.daggerinjection.databinding.ActivityMovieBinding
import br.com.raveline.daggerinjection.mvvm.presentation.di.Injector
import br.com.raveline.daggerinjection.mvvm.presentation.movie.movie_viewmodel.MovieViewModel
import br.com.raveline.daggerinjection.mvvm.presentation.movie.movie_viewmodel.MovieViewModelFactory
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this,factory).get(MovieViewModel::class.java)

      try{
          val responseLiveData = movieViewModel.getMovies()
          responseLiveData.observe(this, { movies ->
              Log.i("MovieActivity", movies.toString())
          })
      }catch (e:Exception){
          e.printStackTrace()
      }

    }
}