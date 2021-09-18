package ru.andreikud.data.model

import com.google.gson.annotations.SerializedName

class DayDto(
    @SerializedName("closes_at") val closesAt: String? = null,
    @SerializedName("is_closed") val isClosed: Boolean? = null,
    @SerializedName("opens_at") val opensAt: String? = null,
)