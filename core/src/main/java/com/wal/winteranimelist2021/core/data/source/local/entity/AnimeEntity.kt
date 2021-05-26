package com.wal.winteranimelist2021.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "anime")
data class AnimeEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id : Int,

    @ColumnInfo(name = "synopsis")
    var synopsis : String,

    @ColumnInfo(name = "source")
    var source : String,

    @ColumnInfo(name = "title")
    var title : String,

    @ColumnInfo(name = "score")
    var score : Double,

    @ColumnInfo(name = "startAiring")
    var startAiring : String,

    @ColumnInfo(name = "episode")
    var episode : Int,

    @ColumnInfo(name = "poster")
    var poster : String,

    @ColumnInfo(name = "genres")
    var genres : String,

    @ColumnInfo(name = "favorite")
    var favorite : Boolean = false
) : Parcelable
