package com.amussio.myfirstapp.data.network

import com.amussio.myfirstapp.data.models.ws.QueryResponseWs
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("api/")
    suspend fun queryPictures(@Query("q") query: String?): QueryResponseWs
}