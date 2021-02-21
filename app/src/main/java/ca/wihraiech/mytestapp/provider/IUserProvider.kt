package ca.wihraiech.mytestapp.provider

import ca.wihraiech.mytestapp.api.model.dto.UserDto
import ca.wihraiech.mytestapp.common.CommonResult

interface IUserProvider {
    suspend fun fetchUserList(): CommonResult<List<UserDto>>?
}