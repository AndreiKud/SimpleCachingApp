package ru.andreikud.data.model

import com.google.gson.annotations.SerializedName

data class RestaurantDto(
    val address: String? = null,
    val description: String? = null,
    val hours: List<DayDto>? = null,
    val id: Int? = null,
    val logo: String? = null,
    val name: String? = null,
    @SerializedName("phone_number") val phoneNumber: String? = null,
    val review: String? = null,
    val type: String? = null,
    val uid: String? = null,
)