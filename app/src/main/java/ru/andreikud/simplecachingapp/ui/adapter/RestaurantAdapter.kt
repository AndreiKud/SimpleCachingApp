package ru.andreikud.simplecachingapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.databinding.RecyclerItemRestaurantBinding

class RestaurantAdapter : ListAdapter<Restaurant, RestaurantAdapter.ViewHolder>(ITEM_CALLBACK) {

    inner class ViewHolder(private val binding: RecyclerItemRestaurantBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurant) {
            with(binding) {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(ivLogo)
                tvName.text = restaurant.name
                tvDesc.text = restaurant.description
                tvType.text = restaurant.type
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerItemRestaurantBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = getItem(position)
        holder.bind(restaurant)
    }

    companion object {
        val ITEM_CALLBACK = object : DiffUtil.ItemCallback<Restaurant>() {
            override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) =
                oldItem == newItem
        }
    }
}