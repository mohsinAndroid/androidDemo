package com.demo.nytimes.domain.repository

import com.demo.nytimes.domain.model.*
import com.demo.prelude.Answer

interface NyTimestRepository {
    suspend fun getNyNews(period: Int,apiKey: String): Answer<List<NyNews>, GetNewsError>
}