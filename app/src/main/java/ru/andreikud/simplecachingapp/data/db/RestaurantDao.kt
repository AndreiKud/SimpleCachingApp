package ru.andreikud.simplecachingapp.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.andreikud.simplecachingapp.data.model.dto.db.RestaurantDbDto

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurant")
    fun getAll(): Flow<List<RestaurantDbDto>>

    @Query("DELETE FROM restaurant")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurants: List<RestaurantDbDto>)

    @Transaction
    suspend fun updateCache(restaurants: List<RestaurantDbDto>) {
        deleteAll()
        insert(restaurants)
    }
}