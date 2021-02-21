package ca.wihraiech.mytestapp.api.model.dto.mapper

import ca.wihraiech.mytestapp.api.model.dto.UserDto
import ca.wihraiech.mytestapp.api.model.pojo.UserPojo

internal fun UserPojo.toUserDto(): UserDto {
    return UserDto(
        id = id,
        userId = userId,
        title = title ?: "",
        body = body ?: ""
    )
}