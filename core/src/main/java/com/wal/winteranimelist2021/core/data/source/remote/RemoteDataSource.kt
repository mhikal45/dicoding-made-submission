package com.wal.winteranimelist2021.core.data.source.remote

import android.util.Log
import com.wal.winteranimelist2021.core.data.source.remote.network.ApiResponse
import com.wal.winteranimelist2021.core.data.source.remote.network.ApiService
import com.wal.winteranimelist2021.core.data.source.remote.response.AnimeItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllAnime () : Flow<ApiResponse<List<AnimeItem>>> {
        return flow {
            try {
                val response = apiService.getList()
                val result = response.anime
                if (result.isNotEmpty()) {
                    emit(ApiResponse.Success(response.anime))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource :",e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}