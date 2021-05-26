package com.wal.winteranimelist2021.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AnimeItem(

    @field:SerializedName("image_url")
	val imageUrl: String,

    @field:SerializedName("mal_id")
	val malId: Int,

    @field:SerializedName("synopsis")
	val synopsis: String,

    @field:SerializedName("source")
	val source: String,

    @field:SerializedName("title")
	val title: String,

    @field:SerializedName("score")
	val score: Double,

    @field:SerializedName("airing_start")
	val airingStart: String,

    @field:SerializedName("genres")
	val genres: List<GenresItem>,

    @field:SerializedName("episodes")
	val episodes: Int
)