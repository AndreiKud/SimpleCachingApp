package ru.andreikud.simplecachingapp.data.network

import retrofit2.http.GET
import retrofit2.http.Query
import ru.andreikud.simplecachingapp.data.model.dto.RestaurantDto

interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
        const val DEFAULT_SIZE = 20
    }

    @GET("restaurant/random_restaurant")
    suspend fun get(@Query("size") size: Int = DEFAULT_SIZE): List<RestaurantDto>

}