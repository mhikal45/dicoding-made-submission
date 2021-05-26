package com.wal.winteranimelist2021.ui.detail

import androidx.lifecycle.ViewModel
import com.wal.winteranimelist2021.core.domain.model.Anime
import com.wal.winteranimelist2021.core.domain.usecase.AnimeUseCase

class DetailViewModel (private val animeUseCase: AnimeUseCase) : ViewModel() {

    fun setAnimeFavorite (anime : Anime, newState : Boolean) = animeUseCase.setFavoriteAnime(anime,newState)
}