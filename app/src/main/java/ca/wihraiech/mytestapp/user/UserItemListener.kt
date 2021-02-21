package ca.wihraiech.mytestapp.user

import ca.wihraiech.mytestapp.api.model.dto.UserDto

interface UserItemListener {
    fun onClick(userDto: UserDto?)
}