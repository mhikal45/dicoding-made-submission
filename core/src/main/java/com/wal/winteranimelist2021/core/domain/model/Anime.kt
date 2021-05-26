package com.wal.winteranimelist2021.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    var id : Int,
    var synopsis : String,
    var title : String,
    var source : String,
    var score : Double,
    var startAiring : String,
    var episode : Int,
    var poster : String,
    var genres : String,
    var favorite : Boolean = false
) : Parcelable
