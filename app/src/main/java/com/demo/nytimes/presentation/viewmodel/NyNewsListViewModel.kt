package com.demo.nytimes.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.demo.nytimes.domain.model.*
import com.demo.nytimes.domain.usecase.*
import com.demo.nytimes.presentation.viewmodel.NyNewsListViewModel.State
import com.demo.nytimes.presentation.viewmodel.NyNewsListViewModel.State.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class NyNewsListViewModel @Inject constructor(
    private val getNyNews: GetNyNewsUseCase

) : BaseViewModel<State>(Idle) {

    fun loadNews(period: Int,apiKey: String) {
        setState(Loading)

        viewModelScope.launch {
            val result = getNyNews(period,apiKey)
            result.fold(
                success = { news ->
                    setState(Content(news))
                },
                error = { error ->
                    setState(Error(error))
                }
            )
        }
    }
    sealed class State {
        object Idle : State()
        object Loading : State()
        data class Content(val nyTimesNews: List<NyNews>) : State()
        data class Error(val getNewsError: GetNewsError) : State()
        object InvalidInput : State()
    }

}