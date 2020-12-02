package ca.wihraiech.mytestapp.paging

import androidx.paging.PagingSource
import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import ca.wihraiech.mytestapp.common.CommonResult
import ca.wihraiech.mytestapp.useCase.IFetchJokesUseCase

class JokeDataSource(
    private val fetchJokesUseCase: IFetchJokesUseCase
) : PagingSource<Int, JokeDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, JokeDto> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val responseData = when (val response = fetchJokesUseCase.execute()) {
                is CommonResult.Success -> {
                    response.data ?: emptyList()
                }
                is CommonResult.Error -> {
                    emptyList()
                }
            }

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}