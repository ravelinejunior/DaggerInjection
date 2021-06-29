package br.com.raveline.daggerinjection.mvvm.presentation.tv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.raveline.daggerinjection.R
import br.com.raveline.daggerinjection.databinding.ListItemBinding
import br.com.raveline.daggerinjection.mvvm.data.model.tv.TvShow
import com.bumptech.glide.Glide

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
        notifyDataSetChanged()
    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShow) {
            val tvShowUrl = "https://image.tmdb.org/t/p/w500" + tvShow.backdropPath
            binding.apply {
                titleTextView.text = tvShow.name
                descriptionTextView.text = tvShow.overview
                Glide.with(imageView.context).load(tvShowUrl).into(imageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tvShow = tvShowList[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = tvShowList.size
}