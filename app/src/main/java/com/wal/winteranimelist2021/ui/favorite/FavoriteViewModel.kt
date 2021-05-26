package com.wal.winteranimelist2021.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.wal.winteranimelist2021.core.domain.usecase.AnimeUseCase

class FavoriteViewModel (animeUseCase: AnimeUseCase) : ViewModel() {
    val favAnime = animeUseCase.getAnimeFavoriteList().asLiveData()
}