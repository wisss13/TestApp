package ca.wihraiech.mytestapp.api.model.dto.mapper

import ca.wihraiech.mytestapp.api.model.pojo.JokePojo
import ca.wihraiech.mytestapp.api.model.dto.JokeDto

internal fun JokePojo.toJokeDto(): JokeDto {
    return JokeDto(
        id = id,
        type = type ?: "",
        setup = setup ?: "",
        punchline = punchline ?: ""
    )
}