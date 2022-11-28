package com.demo.nytimes.data.remote

import com.demo.nytimes.data.model.*
import retrofit2.Response
import retrofit2.http.*

internal interface NyApiService {

    @GET("viewed/{period}.json")
    suspend fun getMostPopularNews (
        @Path("period") period: Int,
        @Query("api-key") apiKey: String
    ): Response<JsonNyTimes>


}