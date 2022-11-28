package com.demo.nytimes.data.repository

import android.util.Log
import com.demo.nytimes.data.mapper.DataMappersFacade
import com.demo.nytimes.data.remote.*
import com.demo.nytimes.domain.model.*
import com.demo.nytimes.domain.repository.NyTimestRepository
import com.demo.prelude.Answer
import kotlinx.coroutines.*
import java.io.IOException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

internal class RealNyTimesRepository @Inject constructor(
    private val nyApiService: NyApiService,
    private val dataMappersFacade: DataMappersFacade,
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : NyTimestRepository {

    override suspend fun getNyNews(period: Int,apiKey: String): Answer<List<NyNews>, GetNewsError> {
        return try {
            withContext(coroutineContext) {
                val apiResult = nyApiService.getMostPopularNews(period,apiKey)

                if (apiResult.isSuccessful) {
                    apiResult.body()?.let { Answer.Success(dataMappersFacade.mapNews(it.results)) }
                        ?: Answer.Error(GetNewsError.NoNewsFound)
                } else {
                    if (apiResult.code() == 404) {
                        Answer.Error(GetNewsError.NoNewsFound)
                    } else {
                        Log.d("apiResult",apiResult.toString())
                        Answer.Error(GetNewsError.GenericError)

                    }
                }
            }
        } catch (e: IOException) {
            Log.d("apiResult",e.toString())

            Answer.Error(GetNewsError.GenericError)
        }
    }




}