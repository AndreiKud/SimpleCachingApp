package ru.andreikud.simplecachingapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.andreikud.simplecachingapp.data.model.domain.Day
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.data.model.domain.Week

@Database(entities = [Day::class, Week::class, Restaurant::class], version = 1)
abstract class RestaurantDatabase : RoomDatabase() {

    abstract fun restaurantDao(): RestaurantDao

}