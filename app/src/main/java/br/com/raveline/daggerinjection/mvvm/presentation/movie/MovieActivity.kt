package br.com.raveline.daggerinjection.mvvm.presentation.movie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.raveline.daggerinjection.R
import br.com.raveline.daggerinjection.databinding.ActivityMovieBinding
import br.com.raveline.daggerinjection.mvvm.presentation.di.Injector
import br.com.raveline.daggerinjection.mvvm.presentation.movie.adapter.MovieAdapter
import br.com.raveline.daggerinjection.mvvm.presentation.movie.movie_viewmodel.MovieViewModel
import br.com.raveline.daggerinjection.mvvm.presentation.movie.movie_viewmodel.MovieViewModelFactory
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent().inject(this)
        movieViewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        adapter = MovieAdapter()
        initRecyclerView()


    }

    private fun initRecyclerView() {
        binding.recyclerViewMovie.apply {
            layoutManager = LinearLayoutManager(this@MovieActivity)
            setHasFixedSize(true)
            adapter = this@MovieActivity.adapter
            displayPopularMovies()
        }
    }

    private fun displayPopularMovies() {
        binding.progressBarMovie.visibility = View.VISIBLE

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, { movies ->
            if (movies != null) {
                adapter.setList(movies)
                adapter.notifyDataSetChanged()
                binding.progressBarMovie.visibility = View.GONE
            } else {
                Toast.makeText(this, "No data Available", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
