package ca.wihraiech.mytestapp.provider

import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import ca.wihraiech.mytestapp.common.CommonResult

interface IJokeProvider {
    suspend fun fetchJokesList(): CommonResult<List<JokeDto>>
}