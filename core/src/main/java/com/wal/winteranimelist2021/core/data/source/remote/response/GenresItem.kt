package com.wal.winteranimelist2021.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GenresItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("mal_id")
	val malId: Int,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("url")
	val url: String
)