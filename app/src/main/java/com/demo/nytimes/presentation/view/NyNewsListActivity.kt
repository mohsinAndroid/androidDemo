package com.demo.nytimes.presentation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.nytimes.R
import com.demo.nytimes.databinding.ActivityNewsListBinding
import com.demo.nytimes.domain.model.*
import com.demo.nytimes.presentation.viewmodel.NyNewsListViewModel
import com.demo.nytimes.presentation.viewmodel.NyNewsListViewModel.State.*
import com.demo.prelude.flowWhenStarted
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NyNewsListActivity : AppCompatActivity() {

    private val nyNewsListViewModel: NyNewsListViewModel by viewModels()


    @Inject
    internal lateinit var newsListRouter: NewsListRouter

    private lateinit var binding: ActivityNewsListBinding
    private val adapter: NyNewsAdapter = NyNewsAdapter { news ->
        newsListRouter.openNewsDetail(
            news
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        observeViewModelState()

        load()
        binding.retryButton.setOnClickListener { load() }

        setUpList()
    }

    private fun load() {
        hideKeyboard()
        nyNewsListViewModel.loadNews(1, "qSGw4MzuJEZAofAY3pM9uBHOCw79Thar")
    }

    private fun setUpList() {
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.newsRecyclerView.adapter = adapter
    }

    private fun observeViewModelState() {
        nyNewsListViewModel.state.flowWhenStarted(this) { state ->
            setDefaultViewsState()

            when (state) {
                is Idle -> binding.infoMessage.isVisible = true
                is Loading -> binding.spinner.isVisible = true
                is Content -> drawContentState(state.nyTimesNews)
                is Error -> drawErrorMessage(state.getNewsError)
                else -> {
                }
            }
        }
    }

    private fun setDefaultViewsState() {
        binding.infoMessage.isVisible = false
        binding.spinner.isVisible = false
        binding.errorMessage.isVisible = false
        binding.newsRecyclerView.isVisible = false
        binding.retryButton.isVisible = false
        adapter.submitList(emptyList())
    }

    private fun drawErrorMessage(getNewsError: GetNewsError) {
        binding.infoMessage.isVisible = true

        when (getNewsError) {
            is GetNewsError.NoNewsFound -> {
                binding.infoMessage.text = getString(R.string.no_news_error_message)
            }
            is GetNewsError.GenericError -> {
                binding.retryButton.isVisible = true
                binding.infoMessage.text = getString(R.string.generic_news_error_message)
            }
        }
    }

    private fun drawContentState(nyNewsList: List<NyNews>) {
        binding.newsRecyclerView.isVisible = true
        adapter.submitList(nyNewsList)
    }

    interface NewsListRouter {
        fun openNewsDetail(news: NyNews)
    }
}