package ru.andreikud.simplecachingapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.data.model.dto.RestaurantDto
import ru.andreikud.simplecachingapp.data.model.toDomain
import ru.andreikud.simplecachingapp.data.network.RestaurantApi
import javax.inject.Inject
import java.net.HttpURLConnection
import java.net.URL

class MainViewModel @Inject constructor(
    private val restaurantApi: RestaurantApi
) : ViewModel() {

    private val _restaurants = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = _restaurants

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val restaurants = restaurantApi.get().map(RestaurantDto::toDomain)
            val restaurantsWithRedirectedLogo = restaurants.map { restaurant ->
                val redirectedLogo = restaurant.logo?.let {
                    getRedirect(it)
                }
                restaurant.copy(logo = redirectedLogo)
            }
            _restaurants.postValue(restaurantsWithRedirectedLogo)
        }
    }

    private suspend fun getRedirect(originUrl: String): String {
        val url = URL(originUrl)
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        urlConnection.instanceFollowRedirects = false
        val result = url.authority + urlConnection.getHeaderField("Location")
        Log.d(TAG, "getRedirect: $result")
        return result
    }
}

private const val TAG = "MainViewModel"