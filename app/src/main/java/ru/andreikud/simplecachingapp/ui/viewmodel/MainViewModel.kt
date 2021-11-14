package ru.andreikud.simplecachingapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.andreikud.simplecachingapp.data.RestaurantRepository
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.util.Resource
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val restaurantsRepository: RestaurantRepository
) : ViewModel() {

    private val _restaurants = MutableStateFlow<Resource<List<Restaurant>>>(Resource.Loading())
    val restaurants = _restaurants.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val data = restaurantsRepository.getRestaurants()
            data.collect { resource ->
                _restaurants.value = resource
            }
        }
    }
}

private const val TAG = "MainViewModel"