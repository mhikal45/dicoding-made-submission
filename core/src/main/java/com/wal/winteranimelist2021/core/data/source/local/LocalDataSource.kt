package com.wal.winteranimelist2021.core.data.source.local

import com.wal.winteranimelist2021.core.data.source.local.entity.AnimeEntity
import com.wal.winteranimelist2021.core.data.source.local.room.AnimeDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val animeDao: AnimeDao){

    fun getAnimeList () : Flow<List<AnimeEntity>> = animeDao.getAnimeList()

    fun getAnimeListFavorite () : Flow<List<AnimeEntity>> = animeDao.getAnimeFavoriteList()

    suspend fun insertAnime (animeList: List<AnimeEntity>) = animeDao.insertAnime(animeList)

    fun setFavoriteAnime (anime : AnimeEntity, newState : Boolean) {
        anime.favorite = newState
        animeDao.updateAnime(anime)
    }
}