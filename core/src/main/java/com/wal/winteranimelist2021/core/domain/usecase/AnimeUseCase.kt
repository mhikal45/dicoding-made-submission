package com.wal.winteranimelist2021.core.domain.usecase

import com.wal.winteranimelist2021.core.data.Resource
import com.wal.winteranimelist2021.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface AnimeUseCase {

    fun getAnimeList () : Flow<Resource<List<Anime>>>
    fun getAnimeFavoriteList () : Flow<List<Anime>>
    fun setFavoriteAnime (anime: Anime,newState : Boolean)
}