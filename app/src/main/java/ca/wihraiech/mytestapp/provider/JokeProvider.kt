package ca.wihraiech.mytestapp.provider

import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import ca.wihraiech.mytestapp.api.model.dto.mapper.toJokeDto
import ca.wihraiech.mytestapp.api.service.ITestService
import ca.wihraiech.mytestapp.common.CommonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JokeProvider(
    private val testService: ITestService
) : IJokeProvider {
    override suspend fun fetchJokesList(): CommonResult<List<JokeDto>>{
        return withContext(Dispatchers.IO) {
            try {
                getJokesList()
            } catch (e: Exception) {
                CommonResult.Error<List<JokeDto>>(e)
            }
        }
    }

    private suspend fun getJokesList(): CommonResult<List<JokeDto>> {
        val response = testService.getRandomTenJokesList()

        return if (response?.isSuccessful == true) {
            val list = response.body()?.map { it.toJokeDto() }
            CommonResult.Success(list)
        }else{
            CommonResult.Error(Exception(response?.message()))
        }

    }
}