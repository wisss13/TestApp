package ca.wihraiech.mytestapp.joke

import ca.wihraiech.mytestapp.api.model.dto.JokeDto

interface JokeItemListener {
    fun onClick(jokeDto: JokeDto?)
}