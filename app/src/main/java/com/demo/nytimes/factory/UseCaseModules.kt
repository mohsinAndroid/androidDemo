package com.demo.nytimes.factory

import com.demo.nytimes.domain.usecase.*
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModules {


    @Singleton
    @Binds
    abstract fun bindGetNyNewsUseCase(getNyNewsUseCaseImpl: GetNyNewsUseCaseImpl): GetNyNewsUseCase


}



