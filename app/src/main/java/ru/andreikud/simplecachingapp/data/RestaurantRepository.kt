package ru.andreikud.simplecachingapp.data

import kotlinx.coroutines.flow.Flow
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.data.networkboundresource.RestaurantsNBR
import ru.andreikud.simplecachingapp.util.Resource
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val restaurantsNBR: RestaurantsNBR
) {
    suspend fun getRestaurants(): Flow<Resource<List<Restaurant>>> {
        return restaurantsNBR.getResource()
    }
}