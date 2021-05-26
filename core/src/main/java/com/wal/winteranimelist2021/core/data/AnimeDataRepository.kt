package com.wal.winteranimelist2021.core.data

import com.wal.winteranimelist2021.core.data.source.local.LocalDataSource
import com.wal.winteranimelist2021.core.data.source.remote.RemoteDataSource
import com.wal.winteranimelist2021.core.data.source.remote.network.ApiResponse
import com.wal.winteranimelist2021.core.data.source.remote.response.AnimeItem
import com.wal.winteranimelist2021.core.domain.model.Anime
import com.wal.winteranimelist2021.core.domain.repository.IAnimeRepository
import com.wal.winteranimelist2021.core.utils.DataMapper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class AnimeDataRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource) : IAnimeRepository {

    override fun getAnimeList(): Flow<Resource<List<Anime>>> =
        object : NetworkBoundResource<List<Anime>, List<AnimeItem>>(){
            override fun loadFromDB(): Flow<List<Anime>> {
                return localDataSource.getAnimeList().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Anime>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<AnimeItem>>> =
                remoteDataSource.getAllAnime()

            override suspend fun saveCallResult(data: List<AnimeItem>) {
                val animeList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertAnime(animeList)
            }

        }.asLiveData()

    override fun getFavoriteAnimeList(): Flow<List<Anime>> =
        localDataSource.getAnimeListFavorite().map { DataMapper.mapEntitiesToDomain(it) }

    override fun setFavoriteAnime(anime: Anime, state: Boolean) {
        val animeEntity = DataMapper.mapDomainToEntity(anime)
        GlobalScope.launch { localDataSource.setFavoriteAnime(animeEntity,state) }
        //appExecutors.diskIO().execute { localDataSource.setFavoriteAnime(animeEntity,state) }
    }
}