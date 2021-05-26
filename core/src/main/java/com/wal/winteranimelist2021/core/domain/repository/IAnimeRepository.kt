package com.wal.winteranimelist2021.core.domain.repository

import com.wal.winteranimelist2021.core.data.Resource
import com.wal.winteranimelist2021.core.domain.model.Anime
import kotlinx.coroutines.flow.Flow

interface IAnimeRepository {

    fun getAnimeList () : Flow<Resource<List<Anime>>>

    fun getFavoriteAnimeList () : Flow<List<Anime>>

    fun setFavoriteAnime (anime: Anime,state : Boolean)
}