package com.wal.winteranimelist2021.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.wal.winteranimelist2021.core.domain.model.Anime
import com.wal.winteranimelist2021.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailViewModel : DetailViewModel by viewModel()
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val detailAnime = intent.getParcelableExtra<Anime>(EXTRA_DATA)
        showDetail(detailAnime)
    }

    private fun showDetail (anime : Anime?) {
        anime.let {
            if (it != null) {
                supportActionBar?.title = it.title
                with(binding) {
                    tvTitle.text = it.title
                    tvDate.text = it.startAiring
                    tvRating.text = it.score.toString()
                    tvSynopsis.text = it.synopsis
                    tvGenre.text = it.genres
                    Glide.with(this@DetailActivity)
                        .load(it.poster)
                        .into(imgPoster)

                    var state = it.favorite
                    btnFavorite.isChecked = state
                    btnFavorite.setOnClickListener {
                        state = !state
                        if (anime != null) {
                            detailViewModel.setAnimeFavorite(anime,state)
                        }
                    }
                }
            }
        }
    }

}