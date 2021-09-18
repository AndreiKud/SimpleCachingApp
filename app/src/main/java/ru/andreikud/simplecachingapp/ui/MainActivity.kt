package ru.andreikud.simplecachingapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.andreikud.simplecachingapp.di.RestaurantApp
import ru.andreikud.simplecachingapp.databinding.ActivityMainBinding
import ru.andreikud.simplecachingapp.ui.adapter.RestaurantAdapter
import ru.andreikud.simplecachingapp.ui.viewmodel.MainViewModel
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

        viewModel.restaurants.observe(this) { restaurants ->
            adapter.submitList(restaurants)
        }
    }
}