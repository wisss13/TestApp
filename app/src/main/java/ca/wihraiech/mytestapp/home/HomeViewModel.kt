package ca.wihraiech.mytestapp.home

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import ca.wihraiech.mytestapp.common.Global.NETWORK_PAGE_SIZE
import ca.wihraiech.mytestapp.paging.JokeDataSource
import ca.wihraiech.mytestapp.repository.UserRepository

class HomeViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    val pagedListConfig = PagingConfig(
        pageSize = NETWORK_PAGE_SIZE,
        prefetchDistance = NETWORK_PAGE_SIZE
    )

//    val listData = Pager(
//        pagedListConfig,
//        pagingSourceFactory = {
//            jokeDataSource
//        }
//    ).liveData.cachedIn(viewModelScope)

    val state = SavedStateHandle()

    // survives process death
    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)
    val listData = currentQuery.switchMap {
        userRepository.getUserList().cachedIn(viewModelScope)
        // by using switchMap, this code will be executed everytime
        // the value of currentQuery changes
    }

    companion object {
        private const val DEFAULT_QUERY = "dogs"
        private const val CURRENT_QUERY = "CURRENT_QUERY"
    }
}