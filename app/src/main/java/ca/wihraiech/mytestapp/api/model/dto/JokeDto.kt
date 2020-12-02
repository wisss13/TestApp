package ca.wihraiech.mytestapp.api.model.dto

data class JokeDto (
    val id : Int,
    val type: String,
    val setup: String,
    val punchline: String

)