package ru.andreikud.simplecachingapp.data.model.domain

import androidx.room.Entity
import ru.andreikud.simplecachingapp.data.model.domain.Day
import ru.andreikud.simplecachingapp.data.model.dto.db.DbDtoType
import ru.andreikud.simplecachingapp.data.model.dto.db.WeekDbDto
import ru.andreikud.simplecachingapp.data.model.dto.network.NetDtoType
import ru.andreikud.simplecachingapp.data.model.dto.network.WeekNetDto

data class Week(
    val monday: Day?,
    val tuesday: Day?,
    val wednesday: Day?,
    val thursday: Day?,
    val friday: Day?,
    val saturday: Day?,
    val sunday: Day?,
) : DomainType {
    override fun toDbDto() = WeekDbDto(
        monday = monday?.toDbDto(),
        tuesday = tuesday?.toDbDto(),
        wednesday = wednesday?.toDbDto(),
        thursday = thursday?.toDbDto(),
        friday = friday?.toDbDto(),
        saturday = saturday?.toDbDto(),
        sunday = sunday?.toDbDto(),
    )

    override fun toNetDto() = WeekNetDto(
        monday = monday?.toNetDto(),
        tuesday = tuesday?.toNetDto(),
        wednesday = wednesday?.toNetDto(),
        thursday = thursday?.toNetDto(),
        friday = friday?.toNetDto(),
        saturday = saturday?.toNetDto(),
        sunday = sunday?.toNetDto(),
    )
}