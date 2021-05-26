package com.wal.winteranimelist2021.core.data.source.local.room

import androidx.room.*
import com.wal.winteranimelist2021.core.data.source.local.entity.AnimeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {

    @Query("SELECT * FROM anime")
    fun getAnimeList () : Flow<List<AnimeEntity>>

    @Query("SELECT * FROM anime WHERE favorite = 1")
    fun getAnimeFavoriteList () : Flow<List<AnimeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnime (animeList : List<AnimeEntity>)

    @Update
    fun updateAnime (anime : AnimeEntity)
}