package ca.wihraiech.mytestapp.useCase

import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import ca.wihraiech.mytestapp.common.CommonResult

interface IFetchJokesUseCase {

    suspend fun execute(): CommonResult<List<JokeDto>>
}