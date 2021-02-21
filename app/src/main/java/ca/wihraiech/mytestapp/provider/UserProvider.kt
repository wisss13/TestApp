package ca.wihraiech.mytestapp.provider

import ca.wihraiech.mytestapp.api.model.dto.UserDto
import ca.wihraiech.mytestapp.api.model.dto.mapper.toUserDto
import ca.wihraiech.mytestapp.api.model.pojo.UserPojo
import ca.wihraiech.mytestapp.api.service.ITestService
import ca.wihraiech.mytestapp.common.CommonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

class UserProvider(
    private val testService: ITestService
) : IUserProvider {
    override suspend fun fetchUserList(): CommonResult<List<UserDto>>? {
        val response = testService.getUsersList()
        return withContext(Dispatchers.IO) {
            getUserList(response)
        }
    }

    private fun getUserList(response: Response<List<UserPojo>>?): CommonResult<List<UserDto>>? {
        return if (response?.isSuccessful == true) {
            val list = response.body()?.map { it.toUserDto() }
            CommonResult.Success(list)
        } else {
            CommonResult.Error(Exception(response?.message()))
        }
    }
}