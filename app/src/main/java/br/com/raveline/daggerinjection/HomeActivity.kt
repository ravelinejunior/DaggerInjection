package br.com.raveline.daggerinjection

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.TEXT_ALIGNMENT_CENTER
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.raveline.daggerinjection.databinding.ActivityHomeBinding
import br.com.raveline.daggerinjection.mvvm.data.api.TesteService
import br.com.raveline.daggerinjection.mvvm.data.api.TmdService
import br.com.raveline.daggerinjection.mvvm.data.model.movie.MovieList
import br.com.raveline.daggerinjection.mvvm.presentation.artist.ArtistActivity
import br.com.raveline.daggerinjection.mvvm.presentation.movie.MovieActivity
import br.com.raveline.daggerinjection.mvvm.presentation.tv.TvShowActivity
import br.com.raveline.daggerinjection.mvvm.utils.language
import br.com.raveline.daggerinjection.mvvm.utils.page
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

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

        val okClient = OkHttpClient.Builder()
            .callTimeout(15000, TimeUnit.MILLISECONDS)
            .writeTimeout(15000, TimeUnit.MILLISECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(okClient)
            .baseUrl(BuildConfig.BASE_URL)
            .build()

      val  tmdService = retrofit.create(TesteService::class.java)

        CoroutineScope(Dispatchers.Main).launch {

            val call = tmdService.getCallMovies(
                BuildConfig.API_KEY, language, page
            )

            call.enqueue(object : Callback<MovieList> {
                override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                    if (response.isSuccessful) {
                        Log.i("HomeActivity", response.body()?.movies.toString())
                    }else{
                        Log.i("HomeActivity", "${response.message()}\n${response.code()}")

                    }
                }

                override fun onFailure(call: Call<MovieList>, t: Throwable) {
                    Log.i("HomeActivity", "${call}\n${t.message}")
                }

            })
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