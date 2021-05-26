package com.wal.winteranimelist2021.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Response(
	@field:SerializedName("anime")
	val anime: List<AnimeItem>
)