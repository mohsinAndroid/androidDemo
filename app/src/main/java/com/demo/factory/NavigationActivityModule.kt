package com.demo.factory

import android.content.Context
import com.demo.nytimes.presentation.view.NyNewsListActivity
import com.demo.navigation.Navigator
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
object NavigationActivityModule {

    @Provides
    fun provideNavigator(
        @ActivityContext context: Context
    ): Navigator = Navigator(context)

    @Provides
    fun provideProjectsListRouter(
        navigator: Navigator
    ): NyNewsListActivity.NewsListRouter = navigator

}