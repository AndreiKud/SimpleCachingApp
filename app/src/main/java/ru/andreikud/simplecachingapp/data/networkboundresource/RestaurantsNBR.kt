package ru.andreikud.simplecachingapp.data.networkboundresource

import kotlinx.coroutines.flow.Flow
import ru.andreikud.simplecachingapp.data.db.RestaurantDatabase
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.data.model.dto.db.RestaurantDbDto
import ru.andreikud.simplecachingapp.data.model.dto.network.RestaurantNetDto
import ru.andreikud.simplecachingapp.data.network.RestaurantApi
import javax.inject.Inject

class RestaurantsNBR @Inject constructor(
    restaurantDb: RestaurantDatabase,
    private val restaurantApi: RestaurantApi
) : BaseNetworkBoundResource<List<RestaurantDbDto>, List<RestaurantNetDto>, List<Restaurant>>() {

    private val dao = restaurantDb.restaurantDao()

    override fun shouldNetQuery(dbData: List<RestaurantDbDto>): Boolean = true

    override fun dbQuery(): Flow<List<RestaurantDbDto>> = dao.getAll()

    override suspend fun saveNetToDb(netData: List<RestaurantNetDto>) {
        dao.insert(netData.map { it.toDbDto() })
    }

    override suspend fun netQuery(): List<RestaurantNetDto> = restaurantApi.get()

    override fun netToDomain(netData: List<RestaurantNetDto>): List<Restaurant> {
        return netData.map { it.toDomain() }
    }

    override fun dbToDomain(dbData: List<RestaurantDbDto>): List<Restaurant> {
        return dbData.map { it.toDomain() }
    }
}