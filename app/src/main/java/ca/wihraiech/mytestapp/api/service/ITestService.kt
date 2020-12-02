package ca.wihraiech.mytestapp.api.service

import ca.wihraiech.mytestapp.api.model.JokePojo
import retrofit2.Response
import retrofit2.http.GET

interface ITestService {

    /**
     * Return the metadata for a JokeData.
     */
    @GET("/random_ten")
    suspend fun getRandomTenJokesList(): Response<List<JokePojo>>?
}