package ru.andreikud.simplecachingapp.data

import ru.andreikud.simplecachingapp.data.db.RestaurantDatabase
import ru.andreikud.simplecachingapp.data.network.RestaurantApi
import ru.andreikud.simplecachingapp.util.networkBoundResource
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val restaurantDatabase: RestaurantDatabase,
    private val restaurantApi: RestaurantApi
) {
    private val dao = restaurantDatabase.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        dbQuery = {
            dao.getAll()
        },
        netQuery = {
            restaurantApi.get()
        },
        saveNetToDb = { restaurantsNetDto ->
            dao.updateCache(restaurantsNetDto.map { it.toDbDto() })
        },
        dbDtoToNetDto = { dbDtoList ->
            dbDtoList.map { it.toNetDto() }
        },
        netDtoToDbDto = { netDtoList ->
            netDtoList.map { it.toDbDto() }
        }
    )
}