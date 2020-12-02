package ca.wihraiech.mytestapp.useCase

import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import ca.wihraiech.mytestapp.common.CommonResult
import ca.wihraiech.mytestapp.provider.IJokeProvider

class FetchJokesUseCase(
    private val jokeProvider: IJokeProvider
) : IFetchJokesUseCase {
    override suspend fun execute(): CommonResult<List<JokeDto>> {
        return jokeProvider.fetchJokesList()
    }
}