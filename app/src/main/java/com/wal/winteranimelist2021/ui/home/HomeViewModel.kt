package com.wal.winteranimelist2021.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.wal.winteranimelist2021.core.domain.usecase.AnimeUseCase

class HomeViewModel ( animeUseCase: AnimeUseCase) : ViewModel() {
    val anime = animeUseCase.getAnimeList().asLiveData()
}