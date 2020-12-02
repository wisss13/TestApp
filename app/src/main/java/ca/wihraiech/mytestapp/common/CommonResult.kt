package ca.wihraiech.mytestapp.common

import ca.wihraiech.mytestapp.api.model.dto.JokeDto

sealed class CommonResult<T> {
    data class Success<T>(val data: T?) : CommonResult<T>()
    data class Error<T>(val error: Exception) : CommonResult<T>()
}