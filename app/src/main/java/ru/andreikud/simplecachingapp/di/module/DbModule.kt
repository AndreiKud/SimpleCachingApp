package ru.andreikud.simplecachingapp.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import ru.andreikud.simplecachingapp.data.db.RestaurantDao
import ru.andreikud.simplecachingapp.data.db.RestaurantDatabase
import javax.inject.Singleton

@Module
class DbModule {

    @Singleton
    @Provides
    fun provideDatabase(
        context: Context
    ): RestaurantDatabase =
        Room.databaseBuilder(context, RestaurantDatabase::class.java, "restaurant_db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideDao(
        db: RestaurantDatabase
    ): RestaurantDao = db.restaurantDao()

}