package com.wal.winteranimelist2021.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wal.winteranimelist2021.core.data.source.local.entity.AnimeEntity

@Database(entities = [AnimeEntity::class],version = 2,exportSchema = false)
abstract class AnimeDatabase : RoomDatabase() {

    abstract fun animeDao () : AnimeDao


}