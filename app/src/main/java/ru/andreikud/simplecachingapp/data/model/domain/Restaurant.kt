package ru.andreikud.simplecachingapp.data.model.domain

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

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
)