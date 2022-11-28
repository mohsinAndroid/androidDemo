package com.demo.navigation

import android.content.Context
import com.demo.nytimes.domain.model.NyNews
import com.demo.nytimes.presentation.view.*

class Navigator(
    private val context: Context
) : NyNewsListActivity.NewsListRouter {
    override fun openNewsDetail(news: NyNews) {
        context.startActivity(
            NyNewsDetailActivity.getStartIntent(
                context,
               news
            )
        )
    }
}