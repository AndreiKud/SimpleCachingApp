package ru.andreikud.simplecachingapp.data.model.domain

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import ru.andreikud.simplecachingapp.data.model.dto.db.DbDtoType
import ru.andreikud.simplecachingapp.data.model.dto.db.RestaurantDbDto
import ru.andreikud.simplecachingapp.data.model.dto.network.NetDtoType
import ru.andreikud.simplecachingapp.data.model.dto.network.RestaurantNetDto

@Entity(tableName = "restaurant")
data class Restaurant(
    val address: String?,
    val description: String?,
    val weekSchedule: Week?,
    val id: Int?,
    val logo: String?,
    val name: String?,
    val phoneNumber: String?,
    val review: String?,
    val type: String?,
    val uid: String?,
) : DomainType {
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