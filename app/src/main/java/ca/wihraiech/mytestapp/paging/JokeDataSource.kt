package ca.wihraiech.mytestapp.paging

import androidx.paging.PagingSource
import ca.wihraiech.mytestapp.api.model.dto.UserDto
import ca.wihraiech.mytestapp.common.CommonResult
import ca.wihraiech.mytestapp.provider.IUserProvider
import ca.wihraiech.mytestapp.provider.UserProvider
import ca.wihraiech.mytestapp.repository.UserRepository

class JokeDataSource(
    private val userProvider: IUserProvider
) : PagingSource<Int, UserDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserDto> {
        val currentLoadingPageKey = params.key ?: 1
        val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1
        return try {
            when (val response = userProvider.fetchUserList()) {
                is CommonResult.Success -> {
                    val responseData = response.data ?: emptyList()
                    LoadResult.Page(
                        data = responseData,
                        prevKey = prevKey,
                        nextKey = currentLoadingPageKey.plus(1)
                    )
                }
                is CommonResult.Error -> {
                    LoadResult.Error(response.error)
                }
                else -> {
                    LoadResult.Error(Exception())
                }
            }


        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}