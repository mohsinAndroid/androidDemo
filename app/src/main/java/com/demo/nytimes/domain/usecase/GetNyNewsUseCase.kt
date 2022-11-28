package com.demo.nytimes.domain.usecase

import com.demo.nytimes.domain.model.*
import com.demo.prelude.Answer

interface   GetNyNewsUseCase {
    suspend operator fun invoke( period: Int,apiKey: String) :  Answer<List<NyNews>, GetNewsError>

}