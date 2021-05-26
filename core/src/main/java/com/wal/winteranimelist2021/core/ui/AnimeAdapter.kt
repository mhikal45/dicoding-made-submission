package com.wal.winteranimelist2021.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wal.winteranimelist2021.core.R
import com.wal.winteranimelist2021.core.databinding.AnimeListBinding
import com.wal.winteranimelist2021.core.domain.model.Anime

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.ViewHolder>() {

    private var listAnime = ArrayList<Anime>()

    var onItemClicked : ((Anime) -> Unit)? = null

    fun setData (inputList : List<Anime>?) {
        if (inputList == null) return
        listAnime.clear()
        listAnime.addAll(inputList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = AnimeListBinding.bind(itemView)

        fun bind (data : Anime) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.poster)
                    .into(imgPoster)
                tvItemTitle.text = data.title
                tvItemDate.text = data.startAiring
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClicked?.invoke(listAnime[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.anime_list,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listAnime[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listAnime.size
}