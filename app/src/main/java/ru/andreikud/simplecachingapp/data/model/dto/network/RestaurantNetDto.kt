package ru.andreikud.simplecachingapp.data.model.dto.network

import com.google.gson.annotations.SerializedName
import ru.andreikud.simplecachingapp.data.model.domain.Restaurant
import ru.andreikud.simplecachingapp.data.model.dto.db.RestaurantDbDto

class RestaurantNetDto(
    val address: String? = null,
    val description: String? = null,
    @SerializedName("hours") val weekSchedule: WeekNetDto? = null,
    val id: Int? = null,
    val logo: String? = null,
    val name: String? = null,
    @SerializedName("phone_number") val phoneNumber: String? = null,
    val review: String? = null,
    val type: String? = null,
    val uid: String? = null,
) : NetDtoType {
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

    override fun toDbDto() = RestaurantDbDto(
        address = address,
        description = description,
        logo = logo,
        weekSchedule = weekSchedule?.toDbDto(),
        name = name,
        id = id,
        phoneNumber = phoneNumber,
        review = review,
        type = type,
        uid = uid,
    )
}