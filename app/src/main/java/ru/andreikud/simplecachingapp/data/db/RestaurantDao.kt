package ru.andreikud.simplecachingapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurant")
    fun getAll(): Flow<List<Restaurant>>

    @Query("DELETE FROM restaurant")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurants: List<Restaurant>)
}