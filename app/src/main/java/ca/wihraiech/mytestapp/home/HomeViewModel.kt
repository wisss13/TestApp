package ca.wihraiech.mytestapp.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import ca.wihraiech.mytestapp.paging.JokeDataSource
import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import ca.wihraiech.mytestapp.common.CommonResult
import ca.wihraiech.mytestapp.useCase.IFetchJokesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    private val fetchJokesUseCase: IFetchJokesUseCase
) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 10)) {
        JokeDataSource(fetchJokesUseCase)
    }.liveData.cachedIn(viewModelScope)
}