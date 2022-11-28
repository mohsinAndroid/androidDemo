package com.demo.nytimes.domain.usecase

import com.demo.nytimes.domain.repository.NyTimestRepository
import javax.inject.Inject

class GetNyNewsUseCaseImpl @Inject constructor(
    private val githubProjectRepository: NyTimestRepository
) : GetNyNewsUseCase {
    override suspend fun invoke(period: Int,apiKey: String) = githubProjectRepository.getNyNews(period,apiKey)


}