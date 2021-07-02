package br.com.raveline.daggerinjection.mvvm.presentation.movie

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.GONE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.raveline.daggerinjection.HomeActivity
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
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarMovie.navigationIcon = getDrawable(R.drawable.ic_baseline_arrow_back_ios_24)
        binding.toolbarMovie.setNavigationOnClickListener {
            navigateUpTo(
                Intent(
                    this@MovieActivity,
                    HomeActivity::class.java
                )
            )
        }
        setSupportActionBar(binding.toolbarMovie)

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
                binding.progressBarMovie.visibility = GONE
            } else {
                Toast.makeText(this, "No data Available", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_update, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_update_action -> {
                updateMovies()
                return true
            }
            else -> return super.onOptionsItemSelected(item)

        }

    }

    private fun updateMovies() {
        binding.progressBarMovie.visibility = View.VISIBLE
        val response = movieViewModel.updateNovies()
        response.observe(this, { movies ->
            if (movies != null) {
                adapter.setList(movies)
                adapter.notifyDataSetChanged()
                binding.progressBarMovie.visibility = GONE
            } else {
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
