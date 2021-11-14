package ru.andreikud.simplecachingapp.data.model.dto.db

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.data.model.dto.network.RestaurantNetDto

@Entity(tableName = "restaurant")
class RestaurantDbDto(
    val address: String? = null,
    val description: String? = null,
    val weekSchedule: WeekDbDto? = null,
    val id: Int? = null,
    val logo: String? = null,
    val name: String? = null,
    val phoneNumber: String? = null,
    val review: String? = null,
    val type: String? = null,
    val uid: String? = null,
) : DbDtoType {

    override fun toDomain() = Restaurant(
        address = address,
        description = description,
        logo = logo,
        weekSchedule = weekSchedule?.toDomain(),
        name = name,
        id = id,
        phoneNumber = phoneNumber,
        review = review,
        type = type,
        uid = uid,
    )

    override fun toNetDto() = RestaurantNetDto(
        address = address,
        description = description,
        logo = logo,
        weekSchedule = weekSchedule?.toNetDto(),
        name = name,
        id = id,
        phoneNumber = phoneNumber,
        review = review,
        type = type,
        uid = uid,
    )
}