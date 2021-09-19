package ru.andreikud.simplecachingapp.data.model.dto.db

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import ru.andreikud.simplecachingapp.data.model.domain.Day
import ru.andreikud.simplecachingapp.data.model.dto.network.DayNetDto

@Entity(tableName = "day")
class DayDbDto(
    val closesAt: String? = null,
    val isClosed: Boolean? = null,
    val opensAt: String? = null,
) : DbDtoType {
    override fun toDomain() = Day(
        closesAt = closesAt,
        opensAt = opensAt,
        isClosed = isClosed,
    )

    override fun toNetDto() = DayNetDto(
        closesAt = closesAt,
        opensAt = opensAt,
        isClosed = isClosed,
    )
}