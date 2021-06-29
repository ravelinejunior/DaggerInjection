package br.com.raveline.daggerinjection.mvvm.presentation.artist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.raveline.daggerinjection.R
import br.com.raveline.daggerinjection.databinding.ListItemBinding
import br.com.raveline.daggerinjection.mvvm.data.model.artist.Artist
import com.bumptech.glide.Glide

class ArtistAdapter : RecyclerView.Adapter<ArtistAdapter.MyViewHolder>() {
    private val artists = ArrayList<Artist>()

    fun setList(artistsList: List<Artist>) {
        artists.clear()
        artists.addAll(artistsList)
        notifyDataSetChanged()
    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(artist: Artist) {
            binding.titleTextView.text = artist.name
            val gender: String = when (artist.gender) {
                1 -> {
                    "Feminino"
                }
                2 -> {
                    "Masculino"
                }
                else -> {
                    "Não informado!"
                }
            }
            binding.descriptionTextView.text =
                "${artist.knownForDepartment}\nPopularidade: ${artist.popularity?.toString()}%\nGênero: $gender"
            val urlImage = "https://image.tmdb.org/t/p/w500" + artist.profilePath
            Glide.with(binding.imageView.context).load(urlImage).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val artist = artists[position]
        holder.bind(artist)
    }

    override fun getItemCount(): Int = artists.size
}