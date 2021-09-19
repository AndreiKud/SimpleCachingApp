package ru.andreikud.simplecachingapp.data.model.dto.network

import com.google.gson.annotations.SerializedName
import ru.andreikud.simplecachingapp.data.model.domain.Day
import ru.andreikud.simplecachingapp.data.model.dto.db.DayDbDto

class DayNetDto(
    @SerializedName("closes_at") val closesAt: String? = null,
    @SerializedName("is_closed") val isClosed: Boolean? = null,
    @SerializedName("opens_at") val opensAt: String? = null,
) : NetDtoType {
    override fun toDomain() = Day(
        closesAt = closesAt,
        opensAt = opensAt,
        isClosed = isClosed,
    )

    override fun toDbDto() = DayDbDto(
        closesAt = closesAt,
        opensAt = opensAt,
        isClosed = isClosed,
    )
}