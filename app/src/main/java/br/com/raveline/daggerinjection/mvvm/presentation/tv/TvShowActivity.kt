package br.com.raveline.daggerinjection.mvvm.presentation.tv

import android.content.Intent
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
import br.com.raveline.daggerinjection.HomeActivity
import br.com.raveline.daggerinjection.R
import br.com.raveline.daggerinjection.databinding.ActivityTvShowBinding
import br.com.raveline.daggerinjection.mvvm.presentation.di.Injector
import br.com.raveline.daggerinjection.mvvm.presentation.tv.adapter.TvShowAdapter
import br.com.raveline.daggerinjection.mvvm.presentation.tv.tv_viewmodel.TvShowViewModel
import br.com.raveline.daggerinjection.mvvm.presentation.tv.tv_viewmodel.TvShowViewModelFactory
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbarTvShow.navigationIcon = getDrawable(R.drawable.ic_baseline_arrow_back_ios_24)
        binding.toolbarTvShow.setNavigationOnClickListener {
            navigateUpTo(
                Intent(
                    this@TvShowActivity,
                    HomeActivity::class.java
                )
            )
        }
        setSupportActionBar(binding.toolbarTvShow)


        (application as Injector).createTvShowSubComponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory).get(TvShowViewModel::class.java)
        tvShowAdapter = TvShowAdapter()
        initRecyclerView()


    }

    private fun initRecyclerView() {
        binding.apply {
            recyclerViewTvShow.layoutManager = LinearLayoutManager(this@TvShowActivity)
            recyclerViewTvShow.setHasFixedSize(true)
            recyclerViewTvShow.adapter = tvShowAdapter
            displayTvShowData()
        }
    }

    private fun displayTvShowData() {
        binding.progressBarTvShow.visibility = VISIBLE

        val responseLiveData = tvShowViewModel.getTvShows()
        responseLiveData.observe(this, { tvShows ->
            if (tvShows != null) {
                tvShowAdapter.setList(tvShows)
                tvShowAdapter.notifyDataSetChanged()
                binding.progressBarTvShow.visibility = GONE
            } else {
                Toast.makeText(this@TvShowActivity, "No data available!", Toast.LENGTH_SHORT).show()
                binding.progressBarTvShow.visibility = GONE
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
                updateTvShowData()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateTvShowData() {
        binding.progressBarTvShow.visibility = VISIBLE

        val responseLiveData = tvShowViewModel.updateTvShows()
        responseLiveData.observe(this@TvShowActivity, { tvShows ->
            if (tvShows != null) {
                tvShowAdapter.setList(tvShows)
                tvShowAdapter.notifyDataSetChanged()
                binding.progressBarTvShow.visibility = GONE
            } else {
                Toast.makeText(
                    this@TvShowActivity,
                    "No data available to update!",
                    Toast.LENGTH_SHORT
                ).show()
                binding.progressBarTvShow.visibility = GONE
            }
        })
    }
}