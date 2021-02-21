package ca.wihraiech.mytestapp.api.service

import ca.wihraiech.mytestapp.api.model.pojo.JokePojo
import ca.wihraiech.mytestapp.api.model.pojo.UserPojo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ITestService {

    /**
     * Return the metadata for a JokeData.
     */
    @GET("/random_ten")
    suspend fun getRandomTenJokesList(): Response<List<JokePojo>>?

    @GET("/posts")
    suspend fun getUsersList(): Response<List<UserPojo>>?
}