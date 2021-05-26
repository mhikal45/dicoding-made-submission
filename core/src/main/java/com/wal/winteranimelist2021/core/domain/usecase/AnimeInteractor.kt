package com.wal.winteranimelist2021.core.domain.usecase

import com.wal.winteranimelist2021.core.data.Resource
import com.wal.winteranimelist2021.core.domain.model.Anime
import com.wal.winteranimelist2021.core.domain.repository.IAnimeRepository
import kotlinx.coroutines.flow.Flow

class AnimeInteractor (private val animeDataRepository: IAnimeRepository) : AnimeUseCase {

    override fun getAnimeList(): Flow<Resource<List<Anime>>> = animeDataRepository.getAnimeList()

    override fun getAnimeFavoriteList(): Flow<List<Anime>> = animeDataRepository.getFavoriteAnimeList()

    override fun setFavoriteAnime(anime: Anime, newState: Boolean) =
        animeDataRepository.setFavoriteAnime(anime,newState)
}