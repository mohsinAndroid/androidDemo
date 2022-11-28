package com.demo.nytimes.factory

import com.demo.nytimes.data.mapper.*

import com.demo.nytimes.data.model.*
import com.demo.nytimes.data.remote.*
import com.demo.nytimes.data.remote.NyApiService
import com.demo.nytimes.data.repository.RealNyTimesRepository
import com.demo.nytimes.domain.model.*
import com.demo.nytimes.domain.repository.NyTimestRepository
import com.demo.nytimes.domain.usecase.*
import com.demo.prelude.ListMapper
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NyNewsModules {


    @Provides
    fun provideService(retrofit: Retrofit): NyApiService =
        retrofit.create(NyApiService::class.java)

    @Provides
    fun providesCoroutineContext(): CoroutineDispatcher = Dispatchers.IO


    @Provides
    fun provideDataMappersFacade(): DataMappersFacade = DataMappersFacade(
        ListMapper(NewsMapper::map)::map
    )

    @Singleton
    @Provides
    fun provideGithubProjectRepository(
        nyApiService: NyApiService,
        dataMappersFacade: DataMappersFacade,
        coroutineContext: CoroutineDispatcher
    ): NyTimestRepository =
        RealNyTimesRepository(
            nyApiService,
            dataMappersFacade,
            coroutineContext
        )

}



