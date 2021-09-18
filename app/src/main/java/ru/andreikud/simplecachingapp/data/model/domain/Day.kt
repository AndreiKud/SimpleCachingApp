package ru.andreikud.simplecachingapp.data.model.domain

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "day")
data class Day(
    val closesAt: String?,
    val isClosed: Boolean?,
    val opensAt: String?,
)