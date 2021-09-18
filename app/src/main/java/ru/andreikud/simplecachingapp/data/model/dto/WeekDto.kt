package ru.andreikud.simplecachingapp.data.model.dto

import com.google.gson.annotations.SerializedName

class WeekDto(
    val monday: DayDto? = null,
    val tuesday: DayDto? = null,
    val wednesday: DayDto? = null,
    val thursday: DayDto? = null,
    val friday: DayDto? = null,
    val saturday: DayDto? = null,
    val sunday: DayDto? = null,
)