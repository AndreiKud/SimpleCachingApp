package ru.andreikud.simplecachingapp.data.model.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class RestaurantDto(
    val address: String? = null,
    val description: String? = null,
    @SerializedName("hours") val weekSchedule: WeekDto? = null,
    val id: Int? = null,
    val logo: String? = null,
    val name: String? = null,
    @SerializedName("phone_number") val phoneNumber: String? = null,
    val review: String? = null,
    val type: String? = null,
    val uid: String? = null,
)