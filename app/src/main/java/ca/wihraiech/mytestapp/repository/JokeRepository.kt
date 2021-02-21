package ca.wihraiech.mytestapp.repository

import ca.wihraiech.mytestapp.api.model.dto.JokeDto
import ca.wihraiech.mytestapp.common.CommonResult
import ca.wihraiech.mytestapp.provider.IJokeProvider

class JokeRepository(private val jokeProvider: IJokeProvider) {

    suspend fun getJokesList(): CommonResult<List<JokeDto>> {
        return jokeProvider.fetchJokesList()
    }
}