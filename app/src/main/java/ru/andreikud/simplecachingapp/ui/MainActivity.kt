package ru.andreikud.simplecachingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collect
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.di.RestaurantApp
import ru.andreikud.simplecachingapp.databinding.ActivityMainBinding
import ru.andreikud.simplecachingapp.ui.adapter.RestaurantAdapter
import ru.andreikud.simplecachingapp.ui.viewmodel.MainViewModel
import ru.andreikud.simplecachingapp.util.Resource
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as RestaurantApp).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = RestaurantAdapter()
        binding.rvRestaurants.adapter = adapter
        binding.rvRestaurants.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launchWhenStarted {
            viewModel.restaurants.collect { resource ->
                adapter.submitList(resource.data)
                binding.apply {
                    pbLoading.isVisible =
                        resource is Resource.Loading && resource.data.isNullOrEmpty()
                    tvError.isVisible =
                        resource is Resource.Error && resource.data.isNullOrEmpty()
                    tvError.text = resource.message
                }
            }
        }
    }
}