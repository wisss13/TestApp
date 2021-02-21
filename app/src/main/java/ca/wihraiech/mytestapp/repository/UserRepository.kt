package ca.wihraiech.mytestapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import ca.wihraiech.mytestapp.api.model.dto.UserDto
import ca.wihraiech.mytestapp.common.CommonResult
import ca.wihraiech.mytestapp.common.Global
import ca.wihraiech.mytestapp.paging.JokeDataSource
import ca.wihraiech.mytestapp.provider.IUserProvider

class UserRepository(
    private val jokeDataSource: JokeDataSource
) {

    fun getUserList() = Pager(
        PagingConfig(
            pageSize = Global.NETWORK_PAGE_SIZE
        ),
        pagingSourceFactory = {
            jokeDataSource
        }
    ).liveData
}