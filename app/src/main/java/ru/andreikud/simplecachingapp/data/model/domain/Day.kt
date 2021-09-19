package ru.andreikud.simplecachingapp.data.model.domain

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import ru.andreikud.simplecachingapp.data.model.dto.db.DayDbDto
import ru.andreikud.simplecachingapp.data.model.dto.db.DbDtoType
import ru.andreikud.simplecachingapp.data.model.dto.network.DayNetDto
import ru.andreikud.simplecachingapp.data.model.dto.network.NetDtoType

data class Day(
    val closesAt: String?,
    val isClosed: Boolean?,
    val opensAt: String?,
) : DomainType {
    override fun toDbDto(): DayDbDto = DayDbDto(
        closesAt = closesAt,
        isClosed = isClosed,
        opensAt = opensAt,
    )

    override fun toNetDto(): DayNetDto = DayNetDto(
        closesAt = closesAt,
        isClosed = isClosed,
        opensAt = opensAt,
    )
}