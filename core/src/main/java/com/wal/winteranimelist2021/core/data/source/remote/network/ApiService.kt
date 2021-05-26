package com.wal.winteranimelist2021.core.data.source.remote.network

import com.wal.winteranimelist2021.core.data.source.remote.response.Response
import retrofit2.http.GET

interface ApiService {
    @GET("season/2021/winter")
    suspend fun getList() : Response
}